package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class PostController {

    @Autowired
     PostService postService;
//    tao bai viet
    @GetMapping("/create-post")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("post/create");
        modelAndView.addObject("create", new Post());
        return modelAndView;
    }

    @PostMapping("/create-post")
    public ModelAndView savePost(@ModelAttribute Post post){
        postService.save(post);

        ModelAndView modelAndView = new ModelAndView("post/create");
        modelAndView.addObject("create", new Post());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
//    hien thi danh sach bai viet
    @GetMapping("/posts")
    public ModelAndView listPosts(){
        List<Post> post = postService.findAll();
        ModelAndView modelAndView = new ModelAndView("/post/list");
        modelAndView.addObject("posts", post);
        return modelAndView;
    }
    // hien thi chi tiet bai viet
    @GetMapping("/view-post/{id}")
    public ModelAndView viewPost(@PathVariable Long id){
       Post post = postService.findById(id);
       ModelAndView modelAndView = new ModelAndView("/post/view");
       modelAndView.addObject("views",post);
       return modelAndView;
    }
//    sua thong tin bai viet
@GetMapping("/edit-post/{id}")
public ModelAndView showEditForm(@PathVariable Long id){
    Post post = postService.findById(id);
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
    public ModelAndView updatePost(@ModelAttribute Post post){
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/edit");
        modelAndView.addObject("post", post);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    // xoa bai viet
    @GetMapping("/delete-post/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Post post = postService.findById(id);
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
        postService.remove(post.getId());
        return "redirect:posts";
    }
}
