package com.na.controller;

import com.na.model.Category;
import com.na.service.ICategoryService;
import com.na.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IPostService iPostService;
    //show list
    @GetMapping("/category")
    public ModelAndView listCategory(){
        Iterable<Category> categories = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
    //show form create and create category
    @GetMapping("/create-category")
    public ModelAndView showCreateCategory(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }
    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute Category category){
        iCategoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("message", " create category was success");
        return modelAndView;
    }
    // show form edit and edit category
    @GetMapping("/edit-category/{id}")
    public  ModelAndView ShowFormEditCategory(@PathVariable("id") Long id, Category category){
        category = iCategoryService.findById(id);
        if(category != null){
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category);
            return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-category")
    public ModelAndView saveEdit( Category category){
        iCategoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category",category);
        modelAndView.addObject("message", "Edit category was success");
        return modelAndView;
    }
    //delete category
    @GetMapping("/delete-category/{id}")
    public  ModelAndView showFormDelete(@PathVariable("id") Long id, Category category){
        category = iCategoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/category/delete");
        modelAndView.addObject("category",category);
        return modelAndView;
    }
    @PostMapping("/delete-category")
    public ModelAndView deleteCategory(@ModelAttribute("category") Category category){
        iCategoryService.remove(category.getId());
        ModelAndView modelAndView = new ModelAndView("/category/list");
        return modelAndView;
    }
    // show view
    @GetMapping("/view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Category category = iCategoryService.findById(id);
        if(category == null){
            return new ModelAndView("/error.404");
        }

        Iterable<com.na.model.Post> posts = iPostService.findAllByCategory(category);

        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("categories", category);
        modelAndView.addObject("post",posts);
        return modelAndView;
    }
}
