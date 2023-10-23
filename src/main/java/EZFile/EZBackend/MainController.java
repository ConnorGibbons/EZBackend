package EZFile.EZBackend;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private PROJ_INFORepository proj_infoRepository;
    @Autowired
    private PROJ_TYPERepository proj_typeRepository;
    @Autowired
    private PROPOSAL_INFORepository proposal_infoRepository;
    @Autowired
    private RES_INFORepository res_infoRepository;
    @Autowired
    private CUST_INFORepository cust_infoRepository;
    @Autowired
    private PERIOD_INFORepository period_infoRepository;
    @Autowired 
    private AUC_INFORepository auc_infoRepository;
    @Autowired
    private ATTACHMENT_FILERepository attachment_fileRepository;
    @Autowired
    private ATTACH_TYPERepository attach_typeRepository;
    @Autowired
    private ATTACH_PROPOSALRepository attach_proposalRepository;

    private List<File> allFiles;

    private Date refreshDate = new Date();

    @GetMapping("/cacheRebuild")
    public String cacheRebuild() {
        System.out.println("Rebuilding cache...");
        refreshDate = new Date();
        allFiles = genAllFiles();
        return "Cache rebuilt in " + diffInMinutes(refreshDate, new Date()) + " minute(s). # Of Files Caches: " + allFiles.size() + ".";
    }

    @GetMapping("/files")
    public List<File> files(
        @RequestParam MultiValueMap<String, String> values) throws Exception {
        System.out.print(values);
        String[] validParameters = {"getFileName", "getAuctionTypes"};

        if (allFiles == null || (diffInMinutes(refreshDate, new Date()) >= 5)) { // If there is no cache or the cache is older than 5 minutes, rebuild the cache.
            allFiles = genAllFiles(); // This might break if two requests come in simultaneously
            refreshDate = new Date();
            System.out.println("No file cache present or cache was outdated, generating one now.");
        }
        
        List<File> resultFiles = allFiles;

        
        //Creates a function that takes a List of files
        BiFunction <List<File>,  Map<String, List<String>>, List<File>> newFunc = (files, fileArgs) -> {
            //filterCategory is the file property to filter by
            //filterRequirements is the query param value that we want to find
            String filterCategory = fileArgs.keySet().toArray()[0].toString();
            List<String> filterRequirements = fileArgs.get(filterCategory);
            filterRequirements.replaceAll(str -> str.toString().toLowerCase());

            List<File> t = files.stream().filter(file -> {
                try {
                    
                    //fileProperty is the value from the current File that we are trying to match with fileRequirements
                    Method m = file.getClass().getMethod(filterCategory);
                    Object fileProperty = m.invoke(file);

                    //if the method from the file returns a list of values, check if any of them are equal to the searched value
                    if (fileProperty.getClass().toString().equals("class java.util.ArrayList")) {




                        for(Object key : (List<Object>)fileProperty) {
                            if(filterRequirements.contains(key.toString().toLowerCase())) {
                                return true;
                            }
                        }
                    //if the get mehtod from the file class returns a single object, check if it is equal to the searched value
                    } else {
                        if(filterRequirements.contains(fileProperty.toString().toLowerCase())) {
                            return true;
                        }
                    }
                
                } catch (Exception e) {

                }
                return false;
            }).collect(Collectors.toList());
            return t;
        };

        for(String key : values.keySet()) {
            Map<String, List<String>> filter = new HashMap<>();
            filter.put(key, values.get(key));

            resultFiles = newFunc.apply(resultFiles, filter);
        };

        return resultFiles;
    }

    public List<File> genAllFiles() {
        List<File> files = new ArrayList<>();
        for (ATTACHMENT_FILE file : attachment_fileRepository.findAll()) {
            files.add(new File(file, cust_infoRepository, period_infoRepository, auc_infoRepository, proj_infoRepository, res_infoRepository));
        }
        return files;
    }

    public Integer diffInMinutes(Date time1, Date time2) {
        return (int) ((time2.getTime() - time1.getTime()) / (1000 * 60));
    }

}