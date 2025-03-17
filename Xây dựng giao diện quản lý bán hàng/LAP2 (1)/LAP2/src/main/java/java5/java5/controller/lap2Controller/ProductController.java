package java5.java5.controller.lap2Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @GetMapping("/product/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("p1", p);
        return "Lap2/from";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("p2") Product product, Model model) {
        model.addAttribute("p2", product);
        return "Lap2/from";
    }

    @ModelAttribute("products")
    public List<Product> getItems() {
        return Arrays.asList(
            new Product("A", 1.0),
            new Product("B", 12.0)
        );
    }
}
