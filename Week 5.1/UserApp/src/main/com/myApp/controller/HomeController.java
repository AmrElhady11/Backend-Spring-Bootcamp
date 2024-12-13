package main.com.myApp.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import main.com.myApp.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showFormPage( Model model)
    {
        model.addAttribute("user",new User());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("user") User user, Model model)
    {

        model.addAttribute("theUser",user);
        return "resultPage";
    }
}


