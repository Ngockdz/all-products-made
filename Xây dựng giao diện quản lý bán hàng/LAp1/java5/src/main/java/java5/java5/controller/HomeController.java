package java5.java5.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class HomeController {
    

    @Autowired 
    ServletContext context;
   
    @GetMapping("/")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        String q = request.getParameter("q");
        model.addAttribute("title", q);
        Cookie cookie  = new Cookie("aBC", "XYZ");
        response.addCookie(cookie);
        response.setHeader("abc", "abc");
        return "home/index";
    }

    @GetMapping("/login/form")
    public String form(Model model) {
        return "login/Login";
    }

     @GetMapping("/rectangle")
    public String showForm() {
        return "home/perimeterofrectangle";
    }

    @PostMapping("/rectangle")
    public String calculate(
            @RequestParam("length") double length,
            @RequestParam("width") double width,
            Model model) {
        double area = length * width;
        double perimeter = 2 * (length + width);

        model.addAttribute("length", length);
        model.addAttribute("width", width);
        model.addAttribute("area", area);
        model.addAttribute("perimeter", perimeter);
        model.addAttribute("calculated", true);

        return "home/perimeterofrectangle";
    }
    
    @PostMapping("/login/check")
    public String login(Model model,  HttpServletRequest request) {
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String message;

        if ("poly".equals(uname) && "123".equals(pass)) {
            model.addAttribute("message", "Login thành công");
            
        } else {model.addAttribute("message", "Login không thành công");
            
        }
        return "login/Login";
    }
    
   
}