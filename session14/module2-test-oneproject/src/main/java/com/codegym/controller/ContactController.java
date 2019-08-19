package com.codegym.controller;

import com.codegym.model.Contact;
import com.codegym.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    // show list
    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public ModelAndView listContact(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Contact> contacts;
        if (s.isPresent()) {
            contacts = contactService.findAllByLastNameContainingOrFirstNameContaining(s.get(),s.get(), pageable);
        } else {
            contacts = contactService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/contact/list");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;

    }

    // create
    @GetMapping(value = "/create-contact", produces = "application/json;charset=UTF-8")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/contact/create");
        modelAndView.addObject("contact", new Contact());
        return modelAndView;
    }

    @PostMapping("/create-contact")
    public ModelAndView saveCreate(@Validated @ModelAttribute("contact") Contact contact, BindingResult bindingResult) throws Exception {
        try {
            if (bindingResult.hasErrors()) {
                return new ModelAndView("/contact/create");
            } else {
                contactService.save(contact);
                ModelAndView modelAndView = new ModelAndView("/contact/create");
                modelAndView.addObject("contact", new Contact());
                modelAndView.addObject("message", "create contact was success");
                return modelAndView;
            }
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("/contact/create");
            modelAndView.addObject("mess", "it is already exist");
            return modelAndView;
        }
    }

    @GetMapping(value = "/edit-contact/{id}", produces = "application/json;charset=UTF-8")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Contact contact = contactService.findById(id);
        if (contact != null) {
            ModelAndView modelAndView = new ModelAndView("/contact/edit");
            modelAndView.addObject("contact", contact);
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-contact")
    public ModelAndView updateContact(@Validated @ModelAttribute("contact") Contact contact, BindingResult bindingResult) throws Exception {
      try{
          if (bindingResult.hasErrors()) {
              return new ModelAndView("/contact/edit");
          } else {
              contactService.save(contact);
              ModelAndView modelAndView = new ModelAndView("/contact/edit");
              modelAndView.addObject("contact", contact);
              modelAndView.addObject("message", "contact updated successfully");
              return modelAndView;
          }
      }
      catch (Exception e) {
          ModelAndView modelAndView = new ModelAndView("/contact/edit");
          modelAndView.addObject("mess", "it is already exist");
          return modelAndView;
      }
    }

    @GetMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.remove(id);
        return "redirect:/list";
    }
}
