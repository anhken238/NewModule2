package com.codegym.controller;

import com.codegym.model.EmployeeGroup;
import com.codegym.service.EmployeeGroupService;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeGroupController {
    @Autowired
    private EmployeeGroupService employeeGroupService;
    @Autowired
    private EmployeeService employeeService;
    //show list
    @GetMapping("/employeegroup")
    public ModelAndView listEmployeeGroup(){
        Iterable<EmployeeGroup> employeeGroups = employeeGroupService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employeegroup/list");
        modelAndView.addObject("employeegroups", employeeGroups);
        return modelAndView;
    }
    //show form create and create category
    @GetMapping("/create-employeegroup")
    public ModelAndView showCreateCategory(){
        ModelAndView modelAndView = new ModelAndView("/employeegroup/create");
        modelAndView.addObject("employeegroup", new EmployeeGroup());
        return modelAndView;
    }
    @PostMapping("/create-employeegroup")
    public ModelAndView saveEmployeeGroup(@ModelAttribute EmployeeGroup employeeGroup){
        employeeGroupService.save(employeeGroup);
        ModelAndView modelAndView = new ModelAndView("/employeegroup/create");
        modelAndView.addObject("message", " create employeegroup was success");
        return modelAndView;
    }
    // show form edit and edit category
    @GetMapping("/edit-employeegroup/{id}")
    public  ModelAndView ShowFormEdit(@PathVariable("id") Long id, EmployeeGroup employeeGroup){
        employeeGroup = employeeGroupService.findById(id);
        if(employeeGroup != null){
            ModelAndView modelAndView = new ModelAndView("/employeegroup/edit");
            modelAndView.addObject("employeegroup", employeeGroup);
            return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-category")
    public ModelAndView saveEdit( EmployeeGroup employeeGroup){
        employeeGroupService.save(employeeGroup);
        ModelAndView modelAndView = new ModelAndView("/employeegroup/edit");
        modelAndView.addObject("employeegroup",employeeGroup);
        modelAndView.addObject("message", "Edit employeegroup was success");
        return modelAndView;
    }
    //delete category
    @GetMapping("/delete-employeegroup/{id}")
    public String groupEmployeeDelete(@PathVariable("id") Long id, EmployeeGroup employeeGroup){
        employeeGroupService.remove(id);
        return "redirect:/employeegroup";
    }

    // show view
    @GetMapping("/view-employeegroup/{id}")
    public ModelAndView viewEmployeeGroup(@PathVariable("id") Long id){
        EmployeeGroup employeeGroup = employeeGroupService.findById(id);
        if(employeeGroup == null){
            return new ModelAndView("/error.404");
        }

        Iterable<com.codegym.model.Employee> employees = employeeService.findAllByEmployeeGroup(employeeGroup);

        ModelAndView modelAndView = new ModelAndView("/employeegroup/view");
        modelAndView.addObject("employeegroup", employeeGroup);
        modelAndView.addObject("employee",employees);
        return modelAndView;
    }
}
