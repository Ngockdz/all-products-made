package edu.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.poly.model.Category;
import edu.poly.model.Product;
import edu.poly.repository.CategoryRepository;
import edu.poly.repository.ProductRepository;

@Controller
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    // Sửa phương thức getCategory()
    public List<Category> getCategories() {
        return categoryRepository.findAll(); // Thêm phương thức findAll() để lấy danh sách Category
    }
    
    @GetMapping(value = {"newOrEdit"})
    public String newOrEdit(ModelMap model) {
        Product product = new Product();
        
        // Thêm danh sách categories vào model để hiển thị trong view
        model.addAttribute("categories", getCategories());
        model.addAttribute("product", product);
        return "product/newOrEdit";
    }
    
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(Product product, RedirectAttributes attributes) {
        // Xử lý lưu product
        productRepository.save(product);
        
        // Thêm thông báo thành công (tuỳ chọn)
        attributes.addFlashAttribute("message", "Product saved successfully!");
        
        return "redirect:/products/newOrEdit"; // Chuyển hướng về trang tạo mới
    }
}