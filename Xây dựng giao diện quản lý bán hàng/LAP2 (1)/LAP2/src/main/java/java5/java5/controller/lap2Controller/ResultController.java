package java5.java5.controller.lap2Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {

    @RequestMapping("/a")
    public String m1() {
        return "Lap2/a"; 
    }

    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b"); 
        return "redirect:Lap2/a"; 
    }

    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addFlashAttribute("message", "I come from c");
        return "redirect:Lap2/a"; 
    }

    @ResponseBody
    @RequestMapping("/d")
    public String m4() {
        return "I come from d"; 
    }
}
