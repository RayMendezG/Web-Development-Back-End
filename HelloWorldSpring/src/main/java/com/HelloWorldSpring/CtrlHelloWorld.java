package com.HelloWorldSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CtrlHelloWorld {
    
    @GetMapping("/HelloWorld")
    public String HeloWorld() {
        return "Hola mundo desde Spring";
    }
}
