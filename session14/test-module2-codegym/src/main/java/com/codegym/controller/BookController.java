package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.BookService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    //show list
    @GetMapping("/book")
    public ModelAndView listCategory(){
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    //show form create
    @GetMapping("/create-book")
    public ModelAndView showCreateCategory(){
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }
    @PostMapping("/create-book")
    public ModelAndView saveBook(@ModelAttribute Book book){
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("message", " create book was success");
        return modelAndView;
    }
    // show form edit and edit book
    @GetMapping("/edit-book/{id}")
    public  ModelAndView ShowFormEditCategory(@PathVariable("id") Long id, Book book){
        book = bookService.findById(id);
        if(book != null){
            ModelAndView modelAndView = new ModelAndView("/book/edit");
            modelAndView.addObject("book", book);
            return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-book")
    public ModelAndView saveEdit( Book book){
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/edit");
        modelAndView.addObject("book",book);
        modelAndView.addObject("message", "Edit book was success");
        return modelAndView;
    }
    //delete book
    @GetMapping("/delete-book/{id}")
    public String showFormDelete(@PathVariable("id") Long id, Book book){
        bookService.remove(id);
        return "redirect:/book";
    }
}
