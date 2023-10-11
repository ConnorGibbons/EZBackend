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
    public int test4(){
        Iterator<PROPOSAL_INFO> data = proposal_infoRepository.findAll().iterator();
        return data.next().getPROJECT_ID();
    }

}
