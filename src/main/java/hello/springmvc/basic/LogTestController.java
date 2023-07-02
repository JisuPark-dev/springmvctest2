package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        log.trace("trace log={}", name);
        log.debug("debug log={}22", name);
        log.info(" info log = {}33", name);
        log.warn("warn log={}44", name);
        log.error("error log={}55", name);
        return "ok";
    }
}
