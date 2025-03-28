package CRUD;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.*;

public class DeleteEmployeeTest {

    @Test
    public void testDeleteEmployeeByEmail() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Truy cập trang quản lý nhân viên
            driver.get("http://localhost:8080/adminusers");
            System.out.println("✔ Đã truy cập trang quản lý nhân viên");

            // Tìm nhân viên theo email
            String targetEmail = "tester_selenium@example.com"; // Thay email cần xóa
            WebElement row = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//td[normalize-space()='" + targetEmail + "']/.."))); // Tìm theo email
            System.out.println("đã tìm thấy email cần xóa");
            
            // Click nút Xóa
            WebElement deleteButton = row.findElement(
                By.xpath(".//a[contains(@class, 'btn-danger')]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
            System.out.println("✔ Đã click nút xóa");

            // Xử lý hộp thoại confirm
            Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
            confirmAlert.accept();
            System.out.println("✔ Đã xác nhận xóa");

            // Verify thông báo thành công
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-success")));
            assertTrue(alert.getText().toLowerCase().contains("xóa thành công"));
            System.out.println("✔ Xóa nhân viên thành công");

        } catch (Exception e) {
            fail("Lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}