package lap.lap4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

@Controller
public class Allcontroller {

    // Display the create form
    @RequestMapping("/staff/create/form")
    public String createForm(Model model, @ModelAttribute("staff") staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "/home/staff-create";
    }

    // Save the staff information and handle file upload
    @RequestMapping("/staff/create/save")
    public String createSave(Model model, 
                             @Valid @ModelAttribute("staff") staff staff, 
                             Errors errors,
                             @RequestPart("photo_file") MultipartFile photoFile) {

        // Check if there are validation errors
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
            return "/home/staff-create"; // Stay on the form if there are validation errors
        }

        // Handle file upload if a photo is uploaded
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename()); // Save the file name
        }

        // Show a success message
        model.addAttribute("message", "Xin chào " + staff.getFullname());
        return "/home/staff-create"; // Redirect or show the success page
    }
}
