package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTest {
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

            // Chờ xem có thông báo lỗi không
            Thread.sleep(3000); // Tạm dừng để chờ thông báo lỗi (có thể thay bằng WebDriverWait)
            if (!driver.findElements(By.cssSelector("div.alert-danger")).isEmpty()) {
                WebElement errorMessage = driver.findElement(By.cssSelector("div.alert-danger"));
                System.out.println("❌ Đăng nhập thất bại: " + errorMessage.getText());
            } else {
                // Điều hướng đến trang chủ nếu đăng nhập thành công
                driver.get("http://localhost:8080/");
                
                // Kiểm tra phần tử đặc trưng trên trang chủ
                WebElement homePageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".navbar-brand") // Thay bằng selector thực tế trên trang chủ
                ));
                System.out.println("✅ Đăng nhập thành công! Đang ở trang chủ");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Lỗi hệ thống: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit(); // Đóng trình duyệt sau khi thực hiện xong
        }
    }
}
