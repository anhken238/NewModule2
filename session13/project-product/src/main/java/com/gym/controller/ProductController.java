package com.gym.controller;

import com.gym.model.Product;
import com.gym.service.ProductImpl;
import com.gym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private ProductService productService = new ProductImpl();

    @GetMapping("/home")
    public String goHome(Model model) {
        model.addAttribute("product", productService.findAll());
        return "index";
    }

    @GetMapping("/create-product")
    public String formCreate(Model model) {
        model.addAttribute("prd", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createSave(Product product, RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 100));
        productService.save(product);
        redirect.addFlashAttribute("message", "Create was success");
        return "redirect:/home";
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("edit", productService.findById(id));
        return "edit";
    }

    @PostMapping("/product/edit")
    public String saveEdit(Product product, RedirectAttributes redirect) {
        this.productService.update(product.getId(), product);
        redirect.addFlashAttribute("message", "edit was success");
        return "redirect:/home";
    }
}
