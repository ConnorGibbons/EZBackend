package EZFile.EZBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private PROJ_INFORepository proj_infoRepository;

    @GetMapping("/test")
    public Iterable<PROJ_INFO> test() {
        return proj_infoRepository.findAll();
    }
}
