package controller;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @GetMapping("/home")
    public String goHome(Model model){
        model.addAttribute("inputInformation", new Employee());
        return "index";
    }
    @PostMapping("/sent")
    String handlingForm(@ModelAttribute Employee employee, BindingResult result, ModelMap model){
        model.addAttribute("id",employee.getId());
        model.addAttribute("firstNameEpl",employee.getFirstName());
        model.addAttribute("lastNameEpl", employee.getLastName());
        model.addAttribute("addressEpl",employee.getAddress());
        model.addAttribute("emailEpl",employee.getEmail());
        model.addAttribute("phoneEpl",employee.getPhone());
        return "information";

    }
}
