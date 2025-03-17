package assgiment.ass.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assgiment.ass.Model.Product;
import assgiment.ass.Model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import assgiment.ass.DAO.ProductDAO;
import assgiment.ass.DAO.UserDAO;


@Controller
public class AccountController {

    @Autowired
    HttpSession session;
    
    @Autowired 
    ServletContext context;

    
    
    @Autowired
    UserDAO userDAO;
      @Autowired
    ProductDAO ProductDAO;




    @GetMapping("/action")
    public String account(Model model) {

        return "Account/action";
    }





    @GetMapping("/disabled")
    public String disabled(Model model) {
        List<User> users = userDAO.findAll();
        model.addAttribute("Allaccount", users); 
        model.addAttribute("pageTitle", "Trang chủ");
        return "Account/disabled";

    }
    @GetMapping("/EMPLOYEE")
    public String EMPLOYEE(Model model) {
        List<User> users = userDAO.findAll();
        model.addAttribute("Allaccount", users); 
        model.addAttribute("pageTitle", "Trang chủ");
        return "Account/EMPLOYEE"; 
    }




}
