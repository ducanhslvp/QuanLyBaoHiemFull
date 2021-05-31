package seleniumtest.cauhinh;

import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl;
import com.detai10.qlbhxh.model.GoiBaoHiem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestGetGoiBH {
    private WebDriver driver;
    private GoiBaoHiemDAO goiBaoHiemDAO=  new GoiBaoHiemDAOImpl();

    @Test
    public void TestGetAllGoiBH(){
        driver.findElement(By.cssSelector("a[href^=cauhinh]")).click();
    }
    @Before
    public void Start(){
        System.setProperty("webdriver.chrome.driver"
                , "D:\\HOC TAP\\NAM 4 KY 2\\Dam bao chat luong phan mem\\DEMO\\Webdriver Chrome\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");

        WebElement txt1=driver.findElement(By.name("username"));
        txt1.sendKeys("a");
        driver.findElement(By.name("password")).sendKeys("a");
        driver.findElement(By.cssSelector("button.btn")).click();

    }
    @After
    public void Finish(){

        driver.quit();
    }
}
