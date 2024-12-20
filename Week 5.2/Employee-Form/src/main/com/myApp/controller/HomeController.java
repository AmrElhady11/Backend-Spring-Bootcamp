package main.com.myApp.controller;

import main.com.myApp.dao.EmployeeRepository;
import main.com.myApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class HomeController
{

    private EmployeeRepository employeeRepository;

    @Autowired
    public HomeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/showForm")
    public String showHomePage(Model model)
    {
        model.addAttribute("empModel" , new Employee());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("empModel") Employee employee,BindingResult bindingResult, Model model) throws SQLException {

        if(bindingResult.hasErrors())
            return "formPage";

       boolean result =  employeeRepository.save(employee);
       if(result)
           System.out.println(String.format("Employee %s saved successfully", employee.getFirstName()));
       else
           System.out.println(String.format("Employee %s save failed", employee.getFirstName()));

        return "resultPage";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}