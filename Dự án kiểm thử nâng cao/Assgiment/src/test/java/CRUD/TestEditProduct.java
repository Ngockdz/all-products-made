package CRUD;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.*;

public class TestEditProduct {

    final String PRODUCT_ID = "43"; // ID của sản phẩm cần chỉnh sửa
    final String EDITED_NAME = "Updated Product " + System.currentTimeMillis();
    final String EDITED_PRICE = "15000";
    final String EDITED_DESCRIPTION = "This is an updated product description";
    final String IMAGE_PATH = "D:\\java5\\AsmGD1\\AsmGD1\\asm\\src\\main\\resources\\static\\img\\NikeAirForce1.jpg"; // Đường dẫn đến ảnh mới

    @Test
    public void testEditProductById() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        try {
            // Bước 1: Đăng nhập vào hệ thống
            driver.get("http://localhost:8080/login");
            
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='email']")
            ));
            emailField.sendKeys("admin.nguyen@example.com");
            
            WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='password']")
            ));
            passField.sendKeys("adminpass");
            
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[type='submit']")
            ));
            loginButton.click();
            
            // Bước 2: Điều hướng đến trang chỉnh sửa sản phẩm theo ID
            driver.get("http://localhost:8080/admin/edit-product/" + PRODUCT_ID);

            // Xác nhận trang chỉnh sửa đã tải thành công
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(), 'Chỉnh sửa sản phẩm')]")
            ));

            // Bước 3: Chỉnh sửa thông tin sản phẩm
            WebElement nameField = driver.findElement(By.name("nameproduct"));
            scrollAndSendKeys(driver, nameField, EDITED_NAME);

            WebElement priceField = driver.findElement(By.name("price"));
            scrollAndSendKeys(driver, priceField, EDITED_PRICE);

            WebElement descField = driver.findElement(By.name("description"));
            scrollAndSendKeys(driver, descField, EDITED_DESCRIPTION);
            
            // Bước 4: Cập nhật ảnh sản phẩm
            WebElement fileInput = driver.findElement(By.name("photoFile"));
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.display = 'block'; arguments[0].style.visibility = 'visible';", 
                fileInput
            );
            fileInput.sendKeys(IMAGE_PATH);

            // Bước 5: Lưu thay đổi
            WebElement submitButton = driver.findElement(
                By.xpath("//button[contains(text(), 'Lưu thay đổi')]")
            );
            submitButton.click();

            // Bước 6: Xác nhận cập nhật thành công
            wait.until(ExpectedConditions.urlToBe("http://localhost:8080/adminproducts"));
            
            WebElement editedProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h5[contains(., '" + EDITED_NAME + "')]")
            ));
            assertTrue("Sản phẩm chưa được cập nhật", editedProduct.isDisplayed());

        } catch (Exception e) {
            takeScreenshot(driver, "edit_product_error");
            fail("Test thất bại: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    private void scrollAndSendKeys(WebDriver driver, WebElement element, String text) {
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", 
            element
        );
        element.clear();
        element.sendKeys(text);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void takeScreenshot(WebDriver driver, String fileName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(fileName + "_screenshot.png"));
        } catch (IOException e) {
            System.err.println("Lỗi khi chụp màn hình: " + e.getMessage());
        }
    }
}
