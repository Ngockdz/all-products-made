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
        // Đặt đường dẫn ChromeDriver (thay đổi nếu cần)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver.exe");

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Mở trang đăng nhập
            driver.get("http://localhost:8080/login");

            // Đợi tối đa 10 giây để phần tử xuất hiện
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Nhập email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            emailField.sendKeys("nhankongnung@gmail.com");
            System.out.println("Đã nhập email");

            // Nhập mật khẩu
            WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passField.sendKeys("1");
            System.out.println("Đã nhập pass");

            // Nhấn nút đăng nhập
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            System.out.println("Đã nhấn nút ");

            // Chờ phản hồi (thông báo lỗi hoặc chuyển hướng)
            boolean isErrorDisplayed = wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-danger")),
                ExpectedConditions.urlContains("/") // Kiểm tra nếu đăng nhập thành công
            ));

            // Kiểm tra kết quả
            if (driver.findElements(By.cssSelector("div.alert-danger")).size() > 0) {
                System.out.println("❌ Đăng nhập thất bại: Sai email hoặc mật khẩu!");
            } else {
                System.out.println("✅ Đăng nhập thành công!");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Lỗi: " + e.getMessage());
        } finally {
            // Đóng trình duyệt sau khi kiểm thử xong
            driver.quit();
        }
    }
}
