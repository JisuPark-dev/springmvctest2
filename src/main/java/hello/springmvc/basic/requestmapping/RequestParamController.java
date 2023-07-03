package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping("/request-param-v")
    public String requestParamV3(String username, int age) {
        log.info("username ={}", username);
        log.info("age ={}", age);
        return "ok";
    }
}
