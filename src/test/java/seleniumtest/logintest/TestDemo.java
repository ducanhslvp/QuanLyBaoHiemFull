package seleniumtest.logintest;

import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;

import static org.junit.jupiter.api.Assertions.*;

public class TestDemo extends TestDriver{
    ChromeDriver chromeDriver = getDriver();
    WebDriverWait wait = new WebDriverWait(chromeDriver,5);

    // ===================== SELENIUM TEST FOR LOGIN ============================
    @Test
    public void loginTitleTest(){
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");
        String title = chromeDriver.getTitle();
        String expectedTitle = "Đăng nhập";
        chromeDriver.close();
       assertEquals(title,expectedTitle, "Title is not as expected!");
    }

    @Test
    public void testLogin1(){
            chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");
            WebElement username = chromeDriver.findElementByName("username");
            username.sendKeys("dongocanh");
            WebElement password = chromeDriver.findElementByName("password");
            password.sendKeys("1");

            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
            element.click();
            String title = chromeDriver.getTitle();
            String expectedTitle = "Quản lý bảo hiểm xã hội";
            chromeDriver.close();
            assertEquals(expectedTitle,title, "Title is not as expected!");
    }

    @Test
    public void testLogin2(){
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");
        WebElement username = chromeDriver.findElementByName("username");
        username.sendKeys("dongocanh");
        WebElement password = chromeDriver.findElementByName("password");
        password.sendKeys("2");


        chromeDriver.findElement(By.tagName("button")).click();
        String error = chromeDriver.findElementByXPath("/html/body/div/div/div/div/div/div/div[2]/div/form/h6").getText();
        String expectedError = "Tên tài khoản hoặc mật khẩu sai";
        chromeDriver.close();
        assertEquals(expectedError,error, "Title is not as expected!");
    }

    @Test
    public void testLogin3() {
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");
        WebElement username = chromeDriver.findElementByName("username");
        username.sendKeys("dongocanh");
        WebElement password = chromeDriver.findElementByName("password");
        password.sendKeys("");


        chromeDriver.findElement(By.tagName("button")).click();
        String notification = chromeDriver.findElementByName("password").getAttribute("validationMessage");
        String expectedNotification = "Please fill out this field.";
        chromeDriver.close();
        assertEquals(expectedNotification,notification, "Wrong expected notification!");
    }

    @Test
    public void testLogin4(){
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");
        WebElement username = chromeDriver.findElementByName("username");
        username.sendKeys("");
        WebElement password = chromeDriver.findElementByName("password");
        password.sendKeys("1");


        chromeDriver.findElement(By.tagName("button")).click();
        String notification = chromeDriver.findElementByName("username").getAttribute("validationMessage");
        String expectedNotification = "Please fill out this field.";
        chromeDriver.close();
        assertEquals(expectedNotification,notification, "Wrong expected notification!");
    }

    @Test
    public void testLogin5(){
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");
        WebElement username = chromeDriver.findElementByName("username");
        username.sendKeys("");
        WebElement password = chromeDriver.findElementByName("password");
        password.sendKeys("");


        chromeDriver.findElement(By.tagName("button")).click();
        String notification = chromeDriver.findElementByName("username").getAttribute("validationMessage");
        String expectedNotification = "Please fill out this field.";
        chromeDriver.close();
        assertEquals(expectedNotification,notification, "Wrong expected notification!");
    }

    // ===================== SELENIUM TEST FOR LOGOUT ============================
    @Test
    public void testLogout1(){
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");
        WebElement username = chromeDriver.findElementByName("username");
        username.sendKeys("dongocanh");
        WebElement password = chromeDriver.findElementByName("password");
        password.sendKeys("1");

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        element.click();
        String title = chromeDriver.getTitle();
        String expectedTitle = "Quản lý bảo hiểm xã hội";
        assertEquals(expectedTitle,title, "Title is not as expected!");

        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/admin");
        WebElement dropmenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"userDropdown\"]/img")));
        dropmenu.click();
        WebElement btnLogout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/nav/ul/li/div/a[2]")));
        btnLogout.click();
        WebElement logoutModal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logoutModal\"]/div/div/div[3]")));
        WebElement choiceYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logoutModal\"]/div/div/div[3]/a")));
        choiceYes.click();
        String titleLogin = chromeDriver.getTitle();
        String expectedTitleLogin = "Đăng nhập";
        chromeDriver.close();
        assertEquals(expectedTitle,title, "Title is not as expected!");
    }

    @Test
    public void testLogout2(){
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");
        WebElement username = chromeDriver.findElementByName("username");
        username.sendKeys("dongocanh");
        WebElement password = chromeDriver.findElementByName("password");
        password.sendKeys("1");

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        element.click();
        String title = chromeDriver.getTitle();
        String expectedTitle = "Quản lý bảo hiểm xã hội";
        assertEquals(expectedTitle,title, "Title is not as expected!");

        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/admin");
        WebElement dropmenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"userDropdown\"]/img")));
        dropmenu.click();
        WebElement btnLogout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/nav/ul/li/div/a[2]")));
        btnLogout.click();
        WebElement logoutModal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logoutModal\"]/div/div/div[3]")));
        WebElement choiceNo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logoutModal\"]/div/div/div[3]/button")));
        choiceNo.click();
        String titleAdmin = chromeDriver.getTitle();
        String expectedTitleAdmin = "Quản lý bảo hiểm xã hội    ";
        chromeDriver.close();
        assertEquals(expectedTitle,title, "Title is not as expected!");
    }
}
