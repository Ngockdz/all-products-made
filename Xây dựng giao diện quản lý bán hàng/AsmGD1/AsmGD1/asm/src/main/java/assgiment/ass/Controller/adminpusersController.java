package assgiment.ass.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import assgiment.ass.Model.User;
import assgiment.ass.DAO.UserDAO;
import java.util.Optional;

@Controller
public class adminpusersController {

    @Autowired
    private UserDAO userDAO;


    @GetMapping("/adminusers")
    public String listUsers(Model model) {
        model.addAttribute("Allaccount", userDAO.findAll());
        return "Account/disabled"; // Đảm bảo template này tồn tại
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "Account/userform";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user,
                           RedirectAttributes redirectAttributes) {
        
        try {
            userDAO.save(user);
            redirectAttributes.addFlashAttribute("success", "Lưu nhân viên thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Lỗi khi lưu: " + e.getMessage());
        }
        return "redirect:/adminusers";
    }
    

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        if (id <= 0) {
            redirectAttributes.addFlashAttribute("error", "ID không hợp lệ!");
            return "redirect:/adminusers";
        }

        Optional<User> userOptional = userDAO.findById(id);
        if (userOptional.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Người dùng không tồn tại!");
            return "redirect:/adminusers";
        }

        model.addAttribute("user", userOptional.get());
        return "Account/edituser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        if (id <= 0) {
            redirectAttributes.addFlashAttribute("error", "ID không hợp lệ!");
            return "redirect:/adminusers";
        }

        Optional<User> userOptional = userDAO.findById(id);
        if (userOptional.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Người dùng không tồn tại!");
            return "redirect:/adminusers";
        }

        try {
            userDAO.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Xóa nhân viên thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Lỗi khi xóa: " + e.getMessage());
        }
        return "redirect:/adminusers";
    }
}
