package seleniumtest.cauhinh;

import com.detai10.qlbhxh.controller.servlet.GoiBaoHiemServlet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.annotation.Rollback;

import java.util.List;

public class TestCauHinh {
    WebDriver driver;
    GoiBaoHiemServlet goiBaoHiemServlet=new GoiBaoHiemServlet();

    @Test
    public void TestDeleteOk(){

        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class*=btn-danger]"));
            elements.get(4).click();

            List<WebElement> elements2 = driver.findElements(By.cssSelector("a[class*=btn-danger]"));

            if (elements2.size()!=elements.size()){
                String text = driver.findElement(By.cssSelector("h6[style*=color]")).getText();
                if (text.equals("")) System.out.println("Passed");
            } else System.out.println("Fail");

        }finally {
        }
    }
    @Test
    public void TestDeleteFail(){

        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class*=btn-danger]"));
            elements.get(0).click();

            List<WebElement> elements2 = driver.findElements(By.cssSelector("a[class*=btn-danger]"));

            if (elements2.size()==elements.size()){
                String text = driver.findElement(By.cssSelector("h6[style*=color]")).getText();
                if (text.equals("Không thể xóa gói này do! Gói đã nằm trong một bảo hiểm")) System.out.println("Passed");

            } else System.out.println("Fail");

        }finally {

        }
    }

    @Before
    public void Start(){
        System.setProperty("webdriver.chrome.driver"
                , "D:\\HOC TAP\\NAM 4 KY 2\\Dam bao chat luong phan mem\\DEMO\\Webdriver Chrome\\chromedriver.exe");
        driver = new ChromeDriver();

//        goiBaoHiemServlet.SetSession();

        driver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");

        WebElement txt1=driver.findElement(By.name("username"));
        txt1.sendKeys("a");
        driver.findElement(By.name("password")).sendKeys("a");
        driver.findElement(By.cssSelector("button.btn")).click();

        driver.findElement(By.cssSelector("a[href^=cauhinh]")).click();
    }
    @After
    public void Finish(){
//        driver.quit();
    }
}
