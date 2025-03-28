package Cart;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class Addproducts {

    @Test
    public void testAddToCartViaModal() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // --- ĐĂNG NHẬP ---
            driver.get("http://localhost:8080/login");
            System.out.println("Đang đăng nhập...");
            
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            emailField.sendKeys("tranthib@example.com");
            
            WebElement passField = driver.findElement(By.name("password"));
            passField.sendKeys("password123");
            
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            
            wait.until(ExpectedConditions.urlContains("/"));
            System.out.println("✔ Đăng nhập thành công");

            // --- TRANG SẢN PHẨM ---
            driver.get("http://localhost:8080/products");
            System.out.println("Đang ở trang sản phẩm...");

            // Chọn một sản phẩm cụ thể (ví dụ ID 10)
            String productId = "2";
            WebElement productCard = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".product-card[data-product-id='" + productId + "']")));
            System.out.println("chọn sản phẩm");

            // Cuộn và click vào card sản phẩm để mở modal
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", productCard);
            Thread.sleep(500);
            productCard.click();
            System.out.println("✔ Đã mở modal chi tiết sản phẩm");

            // --- XỬ LÝ MODAL ---
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productModal")));
            
            // Thêm số lượng (nếu cần)
            WebElement quantityInput = modal.findElement(By.name("quantity"));
            quantityInput.clear();
            quantityInput.sendKeys("2");
            
//            WebElement quantityInput = modal.findElement(By.name("quantity"));
//            int currentQuantity = Integer.parseInt(quantityInput.getAttribute("value")); // Lấy giá trị hiện tại
//            int newQuantity = Math.max(1, currentQuantity - 1); // Giảm 1 nhưng không nhỏ hơn 1
//
//            quantityInput.clear();
//            quantityInput.sendKeys(String.valueOf(newQuantity));

            
            // Click nút thêm vào giỏ hàng trong modal
            WebElement addButton = modal.findElement(By.cssSelector(".add-to-cart-btn"));
            addButton.click();
            System.out.println("✔ Đã click thêm vào giỏ hàng");

            driver.get("http://localhost:8080/cart");
            System.out.println("✔ Kiểm tra giỏ hàng thành công");

        } catch (Exception e) {
            fail("Lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {

            }
        }
    }
}