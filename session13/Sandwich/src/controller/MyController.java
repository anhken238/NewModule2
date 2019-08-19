package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    @GetMapping("/home")
    public String home(){
        return "index";
    }
    @GetMapping("/save")
    public String save(@RequestParam String condiment, Model model) {
        model.addAttribute("result",condiment);
        return "index";
    }
}
