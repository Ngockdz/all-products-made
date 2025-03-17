package java5.java5.controller;



import java.io.File;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;




@Controller
public class HomeController {
    

    @Autowired 
    ServletContext context;
   
    @ModelAttribute("now")
    public Date getDate() {
        return new Date(0);
    }
    
    


    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("q") String q) {
        return "home/index";
    }

    @GetMapping("/login/form")
    public String form(Model model, @RequestParam("pate") Optional<Integer> pate) {
        int page = pate.orElse(0);
        model.addAttribute("message", page);
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
    public String login(Model model,          
            Staff bean,
            @RequestParam("file") MultipartFile file) {
            String message;
    
      
        if (bean.uname.equals("poly") && bean.pass.equals("123")) {
            model.addAttribute("message", "Login thành công");
        } else {
            model.addAttribute("message", "Login không thành công");
        }
    
        String dir = "C:\\Java5\\demo\\java5\\src\\main\\resources\\templates\\img";
        if (!file.isEmpty()) {
       
            File uploadDir = new File(dir);

   
    
            String fileName = file.getOriginalFilename();
            try {
                file.transferTo(new File(uploadDir, fileName));
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("fileError", "Không thể tải lên file: " + e.getMessage());
            }
        } else {
            model.addAttribute("fileError", "Vui lòng chọn một file để tải lên.");
        }
    
        return "login/Login";
    }
    
    
   
}