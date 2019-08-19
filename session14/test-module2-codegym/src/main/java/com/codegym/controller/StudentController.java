package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Student;
import com.codegym.service.BookService;
import com.codegym.service.StudentService;
import javassist.bytecode.stackmap.BasicBlock;
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
public class StudentController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;

    @ModelAttribute("books")
    public Iterable<Book> employeeGroups() {
        return bookService.findAll();
    }


    // show list
    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public ModelAndView listStudent(@ModelAttribute("s") Optional<String> s, Pageable pageable) {
        Page<Student> students;
        if (s.isPresent()) {
            students = studentService.findAllByNameContaining(s.get(), pageable);
        } else {
            students = studentService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;

    }

    // create
    @GetMapping(value = "/create-student", produces = "application/json;charset=UTF-8")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping(value = "/create-student", produces = "application/json;charset=UTF-8")
    public ModelAndView saveCreateStudent(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult) throws Exception {
        try {
            if (bindingResult.hasErrors()) {
                return new ModelAndView("/student/create");
            } else {
                studentService.save(student);
                ModelAndView modelAndView = new ModelAndView("/student/create");
                modelAndView.addObject("student", new Student());
                modelAndView.addObject("message", "create student was success");
                return modelAndView;
            }
        }
        catch (Exception e){
            ModelAndView modelAndView = new ModelAndView("/student/create");
            modelAndView.addObject("mess","it is already exist");
            return modelAndView;
        }
    }
//@PostMapping("/create-student")
//public ModelAndView saveCreateStudent(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult) {
//            Student studentCode = studentService.findByCode(student.getCode());
//        if (bindingResult.hasErrors()|| studentCode.getCode().equals(student.getCode())) {
//            ModelAndView modelAndView = new ModelAndView("/student/create");
//            modelAndView.addObject("mess","it is already exist");
//            return modelAndView;
//        } else {
//            studentService.save(student);
//            ModelAndView modelAndView = new ModelAndView("/student/create");
//            modelAndView.addObject("student", new Student());
//            modelAndView.addObject("message", "create student was success");
//            return modelAndView;
//        }
//}
//    @GetMapping(value = "/edit-student/{id}", produces = "application/json;charset=UTF-8")
//    public ModelAndView showEditForm(@PathVariable Long id){
//        Student student = studentService.findById(id);
//        if(student != null) {
//            ModelAndView modelAndView = new ModelAndView("/student/edit");
//            modelAndView.addObject("student", student);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }

    @PostMapping("/edit-student")
    public ModelAndView updateNote(@Validated @ModelAttribute("student") Student student,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            return modelAndView;
        } else {
            studentService.save(student);
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student", student);
            modelAndView.addObject("message", "student updated successfully");
            return modelAndView;
        }
    }

    @GetMapping("/delete-student/{id}")
    public String deleteEmployee(@PathVariable Long id){
        studentService.remove(id);
        return "redirect:/list";
    }
    @GetMapping(value = "/view-employee/{id}", produces = "application/json;charset=UTF-8" )
    public  ModelAndView viewEmployee(@PathVariable Long id){
        Student student = studentService.findById(id);
        if(student != null) {
            ModelAndView modelAndView = new ModelAndView("/student/view");
            modelAndView.addObject("student", student);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

}
