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

    @GetMapping("/files")
    public List<File> files(
        @RequestParam MultiValueMap<String, String> values) throws Exception {

        String[] validParameters = {"getFileName", "getAuctionTypes"};
        List<BiFunction<List<File>, String, List<File>>> functionList = new ArrayList<>();

        if (allFiles == null || (diffInMinutes(refreshDate, new Date()) >= 5)) { // If there is no cache or the cache is older than 5 minutes, rebuild the cache.
            allFiles = genAllFiles(); // This might break if two requests come in simultaneously 
            System.out.println("No file cache present or cache was outdated, generating one now.");
        }
        List<File> resultFiles = allFiles;

        
        
        BiFunction <List<File>,  Map<String, List<String>>, List<File>> newFunc = (files, fileArgs) -> {
            List<File> t = files.stream().filter(file -> {
                try {
                    //filterCategory is the file property to filter by
                    String filterCategory = fileArgs.keySet().toArray()[0].toString();
                    List<String> filterRequirements = fileArgs.get(filterCategory);
                    filterRequirements.replaceAll(str -> str.toString().toLowerCase());

                    Method m = file.getClass().getMethod(filterCategory);
                    Object fileProperty = m.invoke(file);
                    //System.out.println(fileProperty.getClass());
                    if (fileProperty.getClass().toString().equals("class java.util.ArrayList")) {
                        List<String> filePropertyList = ((List<String>)fileProperty).stream().collect(Collectors.toList());

                        //System.out.println(!Collections.disjoint(filePropertyList, filterRequirements));
                        
                    } else {
                        if(filterRequirements.contains(fileProperty.toString().toLowerCase())) {
                            return true;
                        }
                    }
                
                   // if(filterRequirements.contains(fileProperty.toString().toLowerCase())) {
                   //     return true;
                    //} 
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
    
        //System.out.println(resultFiles);

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
