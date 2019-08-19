package com.na.controller;

import com.na.model.User;
import com.na.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository ;
    @GetMapping("/form")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/form-register")
    public  ModelAndView registerUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("user");
            return modelAndView;
        }
        else{
            userRepository.save(user);
            ModelAndView modelAndView = new ModelAndView("result");
            modelAndView.addObject("users",user);
            modelAndView.addObject("message", "Register was success");

            return modelAndView;
        }
    }
}
