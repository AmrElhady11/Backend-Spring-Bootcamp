package secutrity.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "Hello World";
    }
    @GetMapping("/manage")
    public String manage() {
        return "Hello admin";
    }
    @GetMapping("/use")
    public String use() {
        return "Hello user";
    }
}
