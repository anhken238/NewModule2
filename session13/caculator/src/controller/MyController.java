package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/sent")
    public String caculator(@RequestParam float firstNumber, float lastNumber, String operator, Model model) {
        float result = 0;
        switch (operator) {
            case "Addition(+)":
                result = firstNumber + lastNumber;
                break;
            case "Subtraction(-)":
                result = firstNumber - lastNumber;
                break;
            case "Multiplication(X)":
                result = firstNumber * lastNumber;
                break;
            case "Division(/)":
                result = firstNumber / lastNumber;
                break;
            default:
                return "index";
        }
        model.addAttribute("result", result);

        return "index";
    }
}
