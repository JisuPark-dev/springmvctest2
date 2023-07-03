package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MappingController {
    @GetMapping("/hello-basic")
    public String helloBasic() {
        log.info("{}","helloBasic");
        return "ok";
    }

    @GetMapping("/mapping/{userId}/order/{order}")
    public String mappingPath(@PathVariable String userId,@PathVariable Long order) {
        log.info("userId : {}, order : {}", userId, order);
        return "ok2";
    }
}
