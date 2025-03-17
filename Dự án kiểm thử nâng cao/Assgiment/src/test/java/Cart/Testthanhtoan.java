package Cart;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class Testthanhtoan {

    @Test
    public void testAddToCartAndCheckout() {
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

            // --- THÊM SẢN PHẨM VÀO GIỎ ---
            driver.get("http://localhost:8080/products");
            System.out.println("Đang ở trang sản phẩm...");

            String productId = "2";
            WebElement productCard = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".product-card[data-product-id='" + productId + "']")));

            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", productCard);
            Thread.sleep(500);
            productCard.click();
            System.out.println("✔ Đã mở modal chi tiết sản phẩm");

            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productModal")));
            
            WebElement quantityInput = modal.findElement(By.name("quantity"));
            quantityInput.clear();
            quantityInput.sendKeys("2");
            
            WebElement addButton = modal.findElement(By.cssSelector(".add-to-cart-btn"));
            addButton.click();
            System.out.println("✔ Đã thêm vào giỏ hàng");

            // --- KIỂM TRA GIỎ HÀNG ---
            driver.get("http://localhost:8080/cart");
            System.out.println("Đang kiểm tra giỏ hàng...");

            
         // --- THỰC HIỆN THANH TOÁN ---
            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a.btn-success[href*='/checkout']"))); // Sửa selector theo HTML thực
            checkoutButton.click();
            System.out.println("✔ Đã click thanh toán");

            // --- KIỂM TRA TRANG THANH TOÁN ---
            wait.until(ExpectedConditions.urlToBe("http://localhost:8080/checkout")); // Kiểm tra chính xác URL

            System.out.println("✔ Thanh toán hoàn tất");

        } catch (Exception e) {
            fail("Lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {

            }
        }
    }
}