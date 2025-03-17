package lap3.lap3.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaffController {

    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("ngocnvpd10469@gmail.com")
                .fullname("Nguyen Van Ngoc")
                .level(2)
                .photo("Screenshot 2024-12-01 021903.jpg")
                .build();
                
        model.addAttribute("staff", staff);
        return "staff-detail";
    }

    @RequestMapping("/staff/list")
public String list(Model model) {
    List<Staff> list = List.of(
        Staff.builder().id("Tranvannhan@gmail.com").fullname("Trần Văn Nhân").level(0).photo("IDOLTV-hinh-nen-may-tinh-anime-one-piece-full-HD-911401.jpg").salary(5000.0).build(),
        Staff.builder().id("Nguyenvanngoc@gmail.com").fullname("Nguyễn Văn Ngọc").level(1).photo("Screenshot 2024-01-17 140900.jpg").salary(6000.0).build(),
        Staff.builder().id("Lechicuong@gmail.com").fullname("Lê chí cường").level(2).photo("Screenshot 2024-12-11 182858.jpg").salary(7000.0).build(),
        Staff.builder().id("Huynhthephuong@gmail.com").fullname("Huỳnh Thế Phương").level(2).photo("Screenshot 2024-12-01 021903.jpg").salary(8000.0).build()
    );
    model.addAttribute("list", list);
    return "staff-list";
}

@RequestMapping("/staff/status")
public String status(Model model) {
    List<Staff> list = List.of(
        Staff.builder().id("Tranvannhan@gmail.com").fullname("Trần Văn Nhân").level(0).salary(5000.0).build(),
        Staff.builder().id("Nguyenvanngoc@gmail.com").fullname("Nguyễn Văn Ngọc").level(1).salary(6000.0).build(),
        Staff.builder().id("Lechicuong@gmail.com").fullname("Lê chí cường").level(2).salary(7000.0).build(),
        Staff.builder().id("Huynhthephuong@gmail.com").fullname("Huỳnh Thế Phương").level(2).salary(8000.0).build()
    );
    model.addAttribute("list", list);
    return "list-status";
}


@RequestMapping("/staff/controls")
public String controls(Model model) {
    List<Staff> list = List.of(
        Staff.builder().id("Tranvannhan@gmail.com").fullname("Trần Văn Nhân").level(0).salary(5000.0).build(),
        Staff.builder().id("Nguyenvanngoc@gmail.com").fullname("Nguyễn Văn Ngọc").level(1).salary(6000.0).build(),
        Staff.builder().id("Lechicuong@gmail.com").fullname("Lê chí cường").level(2).salary(7000.0).build(),
        Staff.builder().id("Huynhthephuong@gmail.com").fullname("Huỳnh Thế Phương").level(2).salary(8000.0).build()
    );
    model.addAttribute("list", list);
    return "list-controls";
}

}
