package com.na.controller;

import com.na.model.Category;
import com.na.model.Post;
import com.na.service.ICategoryService;
import com.na.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private IPostService iPostService;
    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

    // show list post
    @GetMapping("/list-post")
    public ModelAndView listPosts(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Post> posts;
        if (s.isPresent()) {
            posts = iPostService.findAllByPostNameContaining(s.get(), pageable);
        } else {
            posts = iPostService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/post/list");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    // create
    @GetMapping("/create-post")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/create-post")
    public ModelAndView saveCreatePost(@ModelAttribute("post") Post post) {
        iPostService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("message", "create post was success");
        return modelAndView;
    }
    @GetMapping("/edit-post/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Post post = iPostService.findById(id);
        if(post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/edit");
            modelAndView.addObject("post", post);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-post")
    public ModelAndView updatePost(@ModelAttribute("post") Post post){
        iPostService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/edit");
        modelAndView.addObject("post", post);
        modelAndView.addObject("message", "post updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-post/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Post post = iPostService.findById(id);
        if(post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/delete");
            modelAndView.addObject("post", post);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-post")
    public String deletePost(@ModelAttribute("post") Post post){
        iPostService.remove(post.getId());
        return "redirect:list-post";
    }
}
