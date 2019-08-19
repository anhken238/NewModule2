package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    Pattern pattern;
    Matcher matcher;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/home")
    public String goHome() {
        return "index";
    }

    @PostMapping("/sent")
    public String handling(@RequestParam String inputEmail, Model model) {
        boolean IsValid = this.validate(inputEmail);
        if (!IsValid) {
            model.addAttribute("message", "EMail is invalid");
            return "index";
        }
        model.addAttribute("email", inputEmail);
        return "success";
    }

    private boolean validate(String inputEmail) {
        matcher = pattern.matcher(inputEmail);
        return matcher.matches();
    }

}
