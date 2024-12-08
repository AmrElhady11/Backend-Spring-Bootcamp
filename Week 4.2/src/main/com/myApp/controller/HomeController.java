package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm( HttpServletRequest request, Model model)
    {
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yearDifference = LocalDate.now().getYear() - Integer.parseInt(year);
        int monthDifference = LocalDate.now().getMonthValue() - Integer.parseInt(month);
        int dayDifference = LocalDate.now().getDayOfMonth() - Integer.parseInt(day);
        model.addAttribute("day", dayDifference);
        model.addAttribute("month" , monthDifference);
        model.addAttribute("year" , yearDifference);

        return "resultPage";
    }
}


