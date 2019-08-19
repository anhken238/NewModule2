package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Set;

@Controller
public class ControllerDictionary {
    @GetMapping("/search")
    public String translate(){
        return "index";
    }
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@RequestParam String worldUS, Model model){
        HashMap<String, String> hash_map = new HashMap<>();
        hash_map.put("run","Chạy" );
        hash_map.put("Cry","Khóc");
        hash_map.put("Mother","Mẹ");
        hash_map.put("Slow","Chậm");
        hash_map.put("Sad","Buồn");
        String result = hash_map.get(worldUS);
        model.addAttribute("worldVN",result);
    return "index";
    }
}
