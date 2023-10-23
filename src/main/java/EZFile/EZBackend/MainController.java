package EZFile.EZBackend;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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
        @RequestParam(name = "fileExtension", required = false, defaultValue = "all") String fileExtension) {
        if (allFiles == null || (diffInMinutes(refreshDate, new Date()) >= 5)) { // If there is no cache or the cache is older than 5 minutes, rebuild the cache.
            refreshDate = new Date();
            allFiles = genAllFiles(); // This might break if two requests come in simultaneously 
            System.out.println("No file cache present or cache was outdated, generated in" + diffInMinutes(refreshDate, new Date()) + " minute(s).");
        }

        if (fileExtension.equals("all")) {
            return allFiles;
        } else {
            return allFiles.stream().filter(file -> file.getFileExtension().equals(fileExtension)).collect(Collectors.toList());
        }
        
    }

    @GetMapping("/filterFiles")
    public List<File> filterFiles(
        @RequestParam(name = "filter", required = false, defaultValue = "none") String filter, @RequestParam(name = "filterName", required = false, defaultValue = "none") Integer filterVal){
        if(filter.equals("fileID")){
            return allFiles.stream().filter(file -> file.getFileID().equals(filterVal)).collect(Collectors.toList());
        }

        return allFiles;
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
