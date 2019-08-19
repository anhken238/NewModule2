package com.code.controller;

import com.code.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/user-form")
    public ModelAndView checkFormValidate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("form");
            return modelAndView;
        }
        else
        {
            ModelAndView modelAndView = new ModelAndView("result");
            return modelAndView;
        }
    }
}
