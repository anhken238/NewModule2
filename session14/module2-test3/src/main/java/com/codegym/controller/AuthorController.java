package com.codegym.controller;

import com.codegym.model.Author;
import com.codegym.service.AuthorService;
import com.codegym.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PostService postService;
    //show list
    @GetMapping("/author")
    public ModelAndView listAuthor(){
        Iterable<Author> authors = authorService.findAll();
        ModelAndView modelAndView = new ModelAndView("/author/list");
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }
    //show form create
    @GetMapping("/create-author")
    public ModelAndView showCreateAuthor(){
        ModelAndView modelAndView = new ModelAndView("/author/create");
        modelAndView.addObject("author", new Author());
        return modelAndView;
    }
    @PostMapping("/create-author")
    public ModelAndView saveAuthor(@ModelAttribute Author author){
        authorService.save(author);
        ModelAndView modelAndView = new ModelAndView("/author/create");
        modelAndView.addObject("author", new Author());
        modelAndView.addObject("message", " create author was success");
        return modelAndView;
    }
    // show form edit and edit author
    @GetMapping("/edit-author/{id}")
    public  ModelAndView ShowFormEditCategory(@PathVariable("id") Long id){
        Author author = authorService.findById(id);
        if(author != null){
            ModelAndView modelAndView = new ModelAndView("/author/edit");
            modelAndView.addObject("author", author);
            return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-author")
    public ModelAndView saveEdit(@ModelAttribute("author") Author author){
        authorService.save(author);
        ModelAndView modelAndView = new ModelAndView("/author/edit");
        modelAndView.addObject("author",author);
        modelAndView.addObject("message", "Edit author was success");
        return modelAndView;
    }
    //delete author
    @GetMapping("/delete-author/{id}")
    public String showFormDelete(@PathVariable("id") Long id, Author author){
        authorService.remove(id);
        return "redirect:/author";
    }
}
