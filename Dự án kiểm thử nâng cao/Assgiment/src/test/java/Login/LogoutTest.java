package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class LogoutTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Mở trang đăng nhập
            driver.get("http://localhost:8080/login");
            System.out.println("Đã mở trang đăng nhập");

            // Nhập thông tin đăng nhập
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            emailField.sendKeys("tranthib@example.com");
            System.out.println("Đã nhập email");

            WebElement passField = driver.findElement(By.name("password"));
            passField.sendKeys("password123");
            System.out.println("Đã nhập mật khẩu");

            // Click nút đăng nhập
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            System.out.println("Đã click nút đăng nhập");

            driver.get("http://localhost:8080/");
            
            // Kiểm tra phần tử đặc trưng trên trang chủ
            WebElement homePageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".navbar-brand") // Thay bằng selector thực tế trên trang chủ
            ));
            
            System.out.println("✅ Đăng nhập thành công! Đang ở trang chủ");
            
         // --- BẮT ĐẦU TEST LOGOUT ---

                
                // Tìm và click nút logout trong navbar
                WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("a.btn.logout-btn[href='/logout']")
                ));
                
                // Scroll đến nút logout nếu cần
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutBtn);
                Thread.sleep(500); // Chờ animation
                
                logoutBtn.click();
                System.out.println("✔ Đã click logout");

                // Verify chuyển hướng
                wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlToBe("http://localhost:8080/login"),
                    ExpectedConditions.urlToBe("http://localhost:8080/")
                ));
                System.out.println("Logout thành công");


            } catch (NoSuchElementException e) {
                System.out.println("❌ Không tìm thấy nút logout");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("⚠️ Lỗi trong quá trình logout: " + e.getMessage());
                e.printStackTrace();
            }  

        
    }
}