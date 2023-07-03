package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request,
                               HttpServletResponse response)
    {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username ={}", username);
        log.info("age ={}", age);
    }

    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam(required = true) String username,
                                 @RequestParam(required = false) Integer age) {
        log.info("username ={}", username);
        log.info("age ={}", age);
        return "ok";
    }
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,
                                 @RequestParam(required = false, defaultValue = "-1") int age) {
        log.info("username ={}", username);
        log.info("age ={}", age);
        return "ok";
    }
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, String> paramMap) {
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @RequestMapping("/request-param-v")
    public String requestParamV3(String username, int age) {
        log.info("username ={}", username);
        log.info("age ={}", age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(HelloData helloData) {
        String username = helloData.getUsername();
        int age = helloData.getAge();
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }
}
