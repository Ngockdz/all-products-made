package assgiment.ass.Controller;

import assgiment.ass.DAO.UserDAO;
import assgiment.ass.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class loginController {
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        return "error-page"; // Đây là tên của trang HTML tùy chỉnh
    }
}


    @Autowired
    private UserDAO userDAO;

    // Hiển thị trang đăng nhập
    @GetMapping("/login")
    public String login(Model model) {
        return "login/login";
    }

    // Xử lý đăng nhập
    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
                               @RequestParam String password,
                               Model model,
                               HttpSession session) {
        User user = userDAO.findByEmail(email);

        if (user == null) {
            model.addAttribute("error", "Email không tồn tại!");
            return "login/login";
        }

        if (!user.getPassword().equals(password)) {
            model.addAttribute("error", "Mật khẩu không chính xác!");
            return "login/login";
        }

        // Lưu thông tin user vào session
        
        session.setAttribute("loggedInUser", user);

        return "redirect:/";
    }






    
    // Hiển thị trang đăng ký
    @GetMapping("/signup")
    public String signup(Model model) {
        return "login/signup";
    }

    // Xử lý đăng ký
    @PostMapping("/signup")
        public String processRegister(@RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String password,
                                    @RequestParam String confirmPassword,
                                    @RequestParam String role, // Thêm tham số role
                                    Model model) {
            // Kiểm tra email đã tồn tại chưa
            if (userDAO.findByEmail(email) != null) {
                model.addAttribute("error", "Email đã được sử dụng!");
                return "login/signup";
            }

            // Kiểm tra mật khẩu nhập lại có khớp không
            if (!password.equals(confirmPassword)) {
                model.addAttribute("error", "Mật khẩu xác nhận không khớp!");
                return "login/signup";
            }

            // Lưu user mới vào database
            User newUser = new User();
            newUser.setUsername(name);
            newUser.setEmail(email);
            newUser.setPassword(password); // Nên mã hóa mật khẩu trước khi lưu vào DB
            newUser.setRole(role); // Lưu vai trò người dùng được chọn

            userDAO.save(newUser);

            // Chuyển hướng sang trang đăng nhập sau khi đăng ký thành công
            return "redirect:/login";
        }



    @GetMapping("/logout")
        public String logout(HttpSession session) {
        session.invalidate();  // Xóa session khi đăng xuất
            return "redirect:/";
        }
    

}