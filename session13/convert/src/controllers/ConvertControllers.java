package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertControllers {
    @GetMapping("/convert")
    public String results(){
        return "handling";
    }
    @RequestMapping(value = "/current", method = RequestMethod.POST)
    public String convert(@RequestParam float inputNumberUSD, Model md){
        md.addAttribute("inputNum", inputNumberUSD);
        if(inputNumberUSD >=0) {
            md.addAttribute("result", inputNumberUSD * 23000);
//            nếu muốn hiển thị kết quả ở trang khác thì sửa return "result";
            return "handling";
        }
        else {
            return "error";
        }
    }
}
