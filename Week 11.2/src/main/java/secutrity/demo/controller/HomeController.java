package secutrity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login";
    }
    @GetMapping("/manage")
    public String manage() {
        return "admin";
    }
    @GetMapping("/use")
    public String use() {
        return "user";
    }
}
