package java5.java5.controller.lap2Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OkController {

    @RequestMapping("/ctrl/ok")
    public String ok() {
        return "Lap2/ok";
    }

    @PostMapping("/ctrl/ok")
    public String m1(Model model) {
        model.addAttribute("methodName", "Admnin");
        return "Lap2/ok";
    }

    @GetMapping("/ctrl/ok")
    public String m2(Model model) {
        model.addAttribute("methodName", "User");
        return "Lap2/ok";
    }

    @RequestMapping(value = "/ctrl/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("methodName", "Main");
        return "Lap2/ok";
    }
}
