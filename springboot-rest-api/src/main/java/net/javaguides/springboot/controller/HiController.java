package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    //HTTP Get Request
    //http://localhost:8080/hi-controller
    @GetMapping("/hi")
    public String HiSomebody()
    {
        return "I need coffee";
    }
}
