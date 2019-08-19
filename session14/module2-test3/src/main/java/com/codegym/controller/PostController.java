package com.codegym.controller;

import com.codegym.model.Author;
import com.codegym.model.Post;
import com.codegym.service.AuthorService;
import com.codegym.service.PostService;
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
public class PostController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PostService postService;

    @ModelAttribute("authors")
    public Iterable<Author> employeeGroups() {
        return authorService.findAll();
    }


    // show list
    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public ModelAndView listPost(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Post> posts;
        if (s.isPresent() && (s.get() != "")) {
            posts = postService.findPostsByAuthorName(s.get().trim(), pageable);
            if(posts.getTotalElements() == 0 ){
                posts = postService.findAllByTitleContaining(s.get().trim(), pageable);
            }
        } else {
            posts = postService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/post/list");
        modelAndView.addObject("posts", posts);
        return modelAndView;

    }

    // create
    @GetMapping(value = "/create-post", produces = "application/json;charset=UTF-8")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/create-post")
    public ModelAndView saveCreate(@Validated @ModelAttribute("post") Post post, BindingResult bindingResult) throws Exception {
        try {
            if (bindingResult.hasErrors()) {
                return new ModelAndView("/post/create");
            } else {
                postService.save(post);
                ModelAndView modelAndView = new ModelAndView("/post/create");
                modelAndView.addObject("post", new Post());
                modelAndView.addObject("message", "create post was success");
                return modelAndView;
            }
        }
        catch (Exception e){
            ModelAndView modelAndView = new ModelAndView("/post/create");
            modelAndView.addObject("mess","it is already exist");
            return modelAndView;
        }
    }
    @GetMapping(value = "/edit-post/{id}", produces = "application/json;charset=UTF-8")
    public ModelAndView showEditForm(@PathVariable Long id){
        Post post = postService.findById(id);
        if(post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/edit");
            modelAndView.addObject("post", post);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-post")
    public ModelAndView updateNote(@Validated @ModelAttribute("post") Post post,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return  new ModelAndView("/post/edit");
        } else {
            postService.save(post);
            ModelAndView modelAndView = new ModelAndView("/post/edit");
            modelAndView.addObject("post", post);
            modelAndView.addObject("message", "post updated successfully");
            return modelAndView;
        }
    }

    @GetMapping("/delete-post/{id}")
    public String deletePost(@PathVariable Long id){
        postService.remove(id);
        return "redirect:/list";
    }
    @GetMapping(value = "/view-author/{id}", produces = "application/json;charset=UTF-8" )
    public  ModelAndView viewEmployee(@PathVariable Long id){
        Author author = authorService.findById(id);
        if(author != null) {
            ModelAndView modelAndView = new ModelAndView("/post/view");
            modelAndView.addObject("author", author);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }
}
