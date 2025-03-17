package CRUD;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.*;

public class EditTestUser {

    final String TARGET_USER_ID = "31";
    final String NEW_USERNAME = "nhantranvan-too";
    final String NEW_EMAIL = "nhantranvan1@example.com";
    final String NEW_PASSWORD = "NewPass1234!";
    final String NEW_ROLE = "Người dùng";
    
    @Test
    public void testUpdateEmployeeWithId45() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        try {
            // 2. Đến trang quản lý user
            driver.get("http://localhost:8080/adminusers");

            // 3. Tìm và click nút Sửa cho user 
            WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//tr[td[text()='" + TARGET_USER_ID + "']]//a[contains(@class,'btn-warning')]"))
            );
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);

            // 4. Chờ form tải xong
            wait.until(ExpectedConditions.urlContains("/edit/" + TARGET_USER_ID));
            
            // 5. Điền thông tin
            WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[name='username']")
            ));
            usernameField.clear();
            usernameField.sendKeys(NEW_USERNAME);

            WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
            emailField.clear();
            emailField.sendKeys(NEW_EMAIL);

            WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));
            passwordField.clear();
            passwordField.sendKeys(NEW_PASSWORD);

            // Chọn role
            WebElement roleSelect = driver.findElement(By.cssSelector("select[name='role']"));
            new Select(roleSelect).selectByVisibleText(NEW_ROLE);

            // 6. Submit form
            WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(text(),'Lưu thay đổi')]"))
            );
            
            // Scroll và click bằng JavaScript
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", 
                submitButton
            );
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

            System.out.println("✅ Cập nhật thành công!");
        } catch (Exception e) {
            System.err.println("❌ Lỗi: " + e.getMessage());
            fail(e.toString());
        } finally {
//            driver.quit();
        }
    }
}