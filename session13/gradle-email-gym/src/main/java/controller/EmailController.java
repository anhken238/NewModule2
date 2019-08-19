package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    Pattern pattern;
    Matcher matcher;
    final String EMAIL_STRING = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailController() {
        pattern = Pattern.compile(EMAIL_STRING);
    }

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    @PostMapping("/validate")
    public String getInformation(@RequestParam String email, Model model) {
        model.addAttribute("input", email);
        boolean IsValid = this.valid(email);
        if (!IsValid){
            model.addAttribute("message", "Email is validate");
            return "index";
        }
        model.addAttribute("email", email);
        return "index";
    }

    private boolean valid(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
