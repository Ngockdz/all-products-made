package assgiment.ass.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import assgiment.ass.Model.Product;
import assgiment.ass.DAO.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class adminproductsController { // 1. Đã sửa tên class theo convention

    @Autowired
    private ProductDAO productDAO;

    private static final String PHOTO_UPLOAD_DIR = "D:\\java5\\AsmGD1\\AsmGD1\\asm\\src\\main\\resources\\static\\img";

    // 2. Thêm xử lý ảnh mặc định
    @GetMapping("/adminproducts")
    public String listProducts(Model model) {
        List<Product> products = productDAO.findAll();
        
        // Xử lý ảnh mặc định
        products.forEach(p -> {
            if(p.getPhoto() == null || p.getPhoto().isEmpty()) {
                p.setPhoto("/images/default-product.jpg");
            }
        });
        
        model.addAttribute("products", products);
        return "Account/another"; // 3. Đảm bảo template another.html tồn tại
    }


    @GetMapping("/admin/add-product")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "Account/productedit";
    }

// Thêm vào adminproductsController
@GetMapping("/admin/edit-product/{id}")
public String showEditForm(@PathVariable("id") Long id, Model model) {
    Product product = productDAO.findById(id)
    .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
    model.addAttribute("product", product);
    return "Account/productedit"; 
}

@PostMapping("/admin/save-product")
public String saveProduct(@ModelAttribute("product") Product product,
                         @RequestParam("photoFile") MultipartFile file,
                         RedirectAttributes redirectAttributes) {
    
    try {
        // Thêm validate kích thước file
        if (file != null && !file.isEmpty()) {
            if (file.getSize() > 10 * 1024 * 1024) { // 10MB
                redirectAttributes.addFlashAttribute("error", "Kích thước file tối đa 10MB");
                return "redirect:/admin/add-product";
            }

            File uploadDir = new File(PHOTO_UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();
            
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(uploadDir, fileName));
            product.setPhoto("/img/" + fileName);
        } else if (product.getPhoto() == null) {
            product.setPhoto("/images/default-product.jpg");
        }
        
        productDAO.save(product);
        
    } catch (IOException e) {
        redirectAttributes.addFlashAttribute("error", "Lỗi upload ảnh: " + e.getMessage());
        return "redirect:/admin/add-product";
    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("error", "Lỗi hệ thống: " + e.getMessage());
        return "redirect:/adminproducts";
    }
    
    return "redirect:/adminproducts";
}

    // 4. Sửa phương thức xóa sang POST
// Sửa lại annotation cho đúng
@PostMapping("/admin/delete-product/{id}")
public String deleteProduct(@PathVariable("id") Long id) {
    productDAO.deleteById(id);
    return "redirect:/adminproducts";
}

    // 5. Thêm xử lý lỗi chung
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Lỗi hệ thống: " + ex.getMessage());
        return "redirect:/adminproducts";
    }
}