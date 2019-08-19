package controller;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

    @RequestMapping(value = "/showform", method = RequestMethod.GET )
    public String formCreate(Model model){
        model.addAttribute("input", new Employee());
        return "create";
    }

    @RequestMapping(value = "/sentInformation", method = RequestMethod.POST)
    public String submit(@ModelAttribute Employee employee, BindingResult result, ModelMap model){
    model.addAttribute("name", employee.getName());
    model.addAttribute("id",employee.getId());
    model.addAttribute("address", employee.getAddress());
    model.addAttribute("phone", employee.getPhone());
    model.addAttribute("email" , employee.getEmail());
    return "information";
    }
}
