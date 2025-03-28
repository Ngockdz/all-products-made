package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SigupTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Mở trang đăng ký
            driver.get("http://localhost:8080/signup");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Nhập thông tin đăng ký
            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
            nameField.sendKeys("Nguyen Van Ngoc");
            System.out.println("Đã nhập tên");

            WebElement emailField = driver.findElement(By.name("email"));
            emailField.sendKeys("ngockdz@124");
            System.out.println("Đã nhập email");

            WebElement passField = driver.findElement(By.name("password"));
            passField.sendKeys("Password123@");
            System.out.println("Đã nhập mật khẩu");

            WebElement confirmPassField = driver.findElement(By.name("confirmPassword"));
            confirmPassField.sendKeys("Password123@");
            System.out.println("Đã xác nhận mật khẩu");


            // Nhấn nút đăng ký
            WebElement signupButton = driver.findElement(By.cssSelector("button[type='submit']"));
            signupButton.click();
            System.out.println("Đã gửi form đăng ký");

            // Kiểm tra kết quả
            boolean isSuccess = wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("/login"), // Chuyển hướng sang trang login
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-danger")) // Hoặc hiển thị lỗi
            ));

            if (driver.getCurrentUrl().contains("/login")) {
                System.out.println("✅ Đăng ký thành công! Đã chuyển hướng sang trang đăng nhập");
            } else {
                WebElement errorMessage = driver.findElement(By.cssSelector("div.alert-danger"));
                System.out.println("❌ Đăng ký thất bại: " + errorMessage.getText());
            }
        } catch (Exception e) {
            System.out.println("⚠️ Lỗi hệ thống: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit(); // Đóng trình duyệt sau khi thực hiện xong
        }
    }
}