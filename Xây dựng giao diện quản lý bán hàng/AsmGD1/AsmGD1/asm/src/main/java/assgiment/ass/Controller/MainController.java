package assgiment.ass.Controller;

import assgiment.ass.DAO.ProductDAO;
import assgiment.ass.Model.Product;
import assgiment.ass.Staff.CartItem;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    private HttpSession session;
    
    @Autowired 
    private ServletContext context;

    @Autowired
    private ProductDAO productDAO;

    // Region: Product Listing
    // =================================================================
    
    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productDAO.findAll();
    
        List<Product> yeuthich = products.stream()
            .filter(p -> p.getId() >= 1 && p.getId() <= 9)
            .collect(Collectors.toList());
        List<Product> hot = products.stream()
            .filter(p -> p.getId() >= 16 && p.getId() <= 22)
            .collect(Collectors.toList());
            List<Product> newProduct = products.stream()
            .filter(p -> p.getId() > 40 )
            .collect(Collectors.toList());
        List<Product> khac = products.stream()
            .filter(p -> p.getId() >= 34 && p.getId() <= 38)
            .collect(Collectors.toList());
    
        // Đưa các danh sách sản phẩm vào model để view có thể sử dụng
        model.addAttribute("yeuthich", yeuthich);
        model.addAttribute("hot", hot);
        model.addAttribute("newProduct", newProduct);
        model.addAttribute("khac", khac);
        return "home/index";
    }

    @GetMapping("/products")
    public String productsPage(Model model) {
        List<Product> products = productDAO.findAll();
    
        List<Product> sneakers = products.stream()
            .filter(p -> p.getId() >= 1 && p.getId() <= 9)
            .collect(Collectors.toList());
        List<Product> running = products.stream()
            .filter(p -> p.getId() >= 10 && p.getId() <= 15)
            .collect(Collectors.toList());
        List<Product> basketball = products.stream()
            .filter(p -> p.getId() >= 16 && p.getId() <= 22)
            .collect(Collectors.toList());
        List<Product> soccer = products.stream()
            .filter(p -> p.getId() >= 23 && p.getId() <= 30)
            .collect(Collectors.toList());
        List<Product> nikeApparel = products.stream()
            .filter(p -> p.getId() >= 31 && p.getId() <= 40)
            .collect(Collectors.toList());
        List<Product> newProduct = products.stream()
            .filter(p -> p.getId() > 40)
            .collect(Collectors.toList());   
    
        // Đưa các danh sách sản phẩm vào model để view có thể sử dụng
        model.addAttribute("sneakers", sneakers);
        model.addAttribute("running", running);
        model.addAttribute("basketball", basketball);
        model.addAttribute("soccer", soccer);
        model.addAttribute("nikeApparel", nikeApparel);
        model.addAttribute("newProduct", newProduct);
    
        return "home/link";
    }
    

    @GetMapping("/search")
    public String searchProducts(@RequestParam(name = "query", required = false) String query, Model model) {
        model.addAttribute("indexstaff", productDAO.findAll().stream().limit(10).toList());
        return "home/search";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {
        return "home/about";
    }

    // Region: Cart Management
    // =================================================================
    
    @GetMapping("/cart")
    public String viewCart(Model model, HttpServletRequest request) {
        List<CartItem> cart = getOrCreateCart(request);
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", calculateTotal(cart));
        model.addAttribute("pageTitle", "Giỏ hàng");
        return "home/cart";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") Long productId,
                           @RequestParam(value = "quantity", defaultValue = "1") int quantity,
                           HttpServletRequest request,
                           RedirectAttributes redirectAttributes) {
        
                            if (productId == null || productId <= 0) {
                                redirectAttributes.addFlashAttribute("error", "ID sản phẩm không hợp lệ");
                                return "redirect:/products";
                            }

        if (session.getAttribute("loggedInUser") == null) {
            redirectAttributes.addFlashAttribute("error", "Vui lòng đăng nhập");
            return "redirect:/login";
        }

        Product product = productDAO.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
        
        updateCartItems(request, product, quantity);
        
        return "redirect:/products";
    }

    @PostMapping("/update-quantity")
    public String updateQuantity(@RequestParam("id") Long productId,
                                @RequestParam("change") int change,
                                HttpServletRequest request,
                                RedirectAttributes redirectAttributes) {
        
        if (productId == null || productId <= 0) {
            redirectAttributes.addFlashAttribute("error", "ID sản phẩm không hợp lệ");
            return "redirect:/cart";
        }
    
        modifyCartQuantity(request, productId, change);
        return "redirect:/cart";
    }

    @GetMapping("/remove-from-cart")
    public String removeItem(@RequestParam("id") Long productId, 
                            HttpServletRequest request,
                            RedirectAttributes redirectAttributes) {
        
        if (productId == null || productId <= 0) {
            redirectAttributes.addFlashAttribute("error", "ID sản phẩm không hợp lệ");
            return "redirect:/cart";
        }
    
        removeFromCart(request, productId);
        return "redirect:/cart";
    }

    @GetMapping("/clear-cart")
    public String clearCart(HttpServletRequest request) {
        request.getSession().setAttribute("cart", new ArrayList<>());
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
public String checkout(HttpServletRequest request, 
                      Model model,
                      RedirectAttributes redirectAttributes) {
    
    // Kiểm tra đăng nhập
    if (request.getSession().getAttribute("loggedInUser") == null) {
        redirectAttributes.addFlashAttribute("error", "Vui lòng đăng nhập để thanh toán");
        return "redirect:/login";
    }

    List<CartItem> cart = getOrCreateCart(request);
    if (cart.isEmpty()) {
        redirectAttributes.addFlashAttribute("error", "Giỏ hàng trống không thể thanh toán");
        return "redirect:/cart";
    }
    
    // Tính tổng tiền và thêm vào model
    BigDecimal total = calculateTotal(cart);
    model.addAttribute("totalPrice", total);
    
    // Xóa giỏ hàng sau khi thanh toán
    request.getSession().removeAttribute("cart");
    
    // Thêm thông báo thành công
    model.addAttribute("message", "Thanh toán thành công! Tổng tiền: " 
        + NumberFormat.getCurrencyInstance().format(total));
    
    return "home/checkout";
}

    // Region: Private Helpers
    // =================================================================
    
    private List<CartItem> getOrCreateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

private BigDecimal calculateTotal(List<CartItem> cart) {
    return cart.stream()
            .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
}

    private void updateCartItems(HttpServletRequest request, Product product, int quantity) {
        List<CartItem> cart = getOrCreateCart(request);
        
        cart.stream()
            .filter(item -> item.getProduct().getId() == product.getId())
            .findFirst()
            .ifPresentOrElse(
                item -> item.setQuantity(item.getQuantity() + quantity),
                () -> cart.add(new CartItem(product, quantity))
            );
    }

    private void modifyCartQuantity(HttpServletRequest request, Long productId, int change) {
        List<CartItem> cart = getOrCreateCart(request);
        
        cart.removeIf(item -> {
            if (item.getProduct().getId() == productId) {
                int newQty = item.getQuantity() + change;
                if (newQty > 0) {
                    item.setQuantity(newQty);
                    return false;
                }
                return true;
            }
            return false;
        });
    }

    private void removeFromCart(HttpServletRequest request, Long productId) {
        List<CartItem> cart = getOrCreateCart(request);
        cart.removeIf(item -> item.getProduct().getId() == productId);
    }
}