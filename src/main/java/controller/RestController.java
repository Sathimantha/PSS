package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/greetings")
public class RestController {
    @GetMapping("/greet")
    public String greet(){
        return "Hello. WAR deployment successful";
    }
}
