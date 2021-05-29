package seleniumtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver driver;

    @Test
    public void TestLoginFail(){
        WebElement txt1=driver.findElement(By.name("username"));
        txt1.sendKeys("a");
        driver.findElement(By.name("password")).sendKeys("aa");
        driver.findElement(By.cssSelector("button.btn")).click();

        String text = driver.findElement(By.cssSelector("h6")).getText();
        if (text.equals("Tên tài khoản hoặc mật khẩu sai")) System.out.println("Passed");
        else System.out.println("Fail");
    }
    @Test
    public void TestLoginOk(){
        WebElement txt1=driver.findElement(By.name("username"));
        txt1.sendKeys("a");
        driver.findElement(By.name("password")).sendKeys("a");
        driver.findElement(By.cssSelector("button.btn")).click();

        String text = driver.findElement(By.cssSelector("h6")).getText();
        if (text.equals("")) System.out.println("Passed");
        else System.out.println("Fail");
    }
    @Before
    public void Start(){
        System.setProperty("webdriver.chrome.driver"
                , "D:\\HOC TAP\\NAM 4 KY 2\\Dam bao chat luong phan mem\\DEMO\\Webdriver Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");
    }
    @After
    public void Finish(){
        driver.quit();
    }
}
