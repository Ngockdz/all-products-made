package java5.java5.controller.lap2Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class ParamController {
    @RequestMapping("/param/form")
    public String form() {
        return "Lap2/from";
    }

    @RequestMapping("/param/save/{x}")
    public String save(@PathVariable String x, @RequestParam String y, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "Lap2/from";
    }
}


