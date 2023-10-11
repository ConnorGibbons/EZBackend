package EZFile.EZBackend;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/test1")
    public Iterable<PROJ_INFO> test1() {
        return proj_infoRepository.findAll();
    }

    @GetMapping("/test2")
    public Iterable<PROJ_TYPE> test2() {
        return proj_typeRepository.findAll();
    }

    @GetMapping("/test3")
    public Iterable<PROPOSAL_INFO> test3() {
        return proposal_infoRepository.findAll();
    }

    @GetMapping("/test4")
    public Iterable<RES_INFO> test4(){
        return res_infoRepository.findAll();
    }

    @GetMapping("/test5")
    public Iterable<CUST_INFO> test5(){
        return cust_infoRepository.findAll();
    }

    @GetMapping("/test6")
    public Iterable<ATTACHMENT_FILE> test6(){
        return attachment_fileRepository.findAll();
    }



}
