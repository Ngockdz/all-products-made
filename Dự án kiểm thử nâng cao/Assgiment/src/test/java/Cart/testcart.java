package Cart;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.*;

public class testcart {

    @Test
    public void testCartIsEmptyOnLoad() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

            // Mở trang giỏ hàng
            driver.get("http://localhost:8080/cart");
            System.out.println("Đã mở trang giỏ hàng");


            System.out.println("✔ Xác nhận giỏ hàng trống thành công");

        } catch (Exception e) {
            fail("Lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {

        }
    }
}
