package seleniumtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMaster {
    WebDriver driver;

    @Test
    public void Test1(){
        WebElement txt1=driver.findElement(By.name("username"));
        txt1.sendKeys("a");
        driver.findElement(By.name("password")).sendKeys("a");
//        driver.findElement(By.linkText("")).sendKeys();//the a
//        driver.findElement(By.cssSelector("button[type=submit][class^=btn][class^*$=block]")).click();
        driver.findElement(By.cssSelector("button.btn")).click();

        //        String value = driver.findElement(By.name("h6[style*=color]")).getText();

//        boolean value = driver.findElement(By.name("h6[style*=color]")).isEnabled();
//        System.out.println(value+"000");

        //            for (WebElement element : elements) {
//                System.out.println("Paragraph text:" + element.getText());
//            }
    }
    @Before
    public void Start(){
        System.setProperty("webdriver.chrome.driver"
                , "D:\\HOC TAP\\NAM 4 KY 2\\Dam bao chat luong phan mem\\DEMO\\Webdriver Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
//        this.driver.manage().window().maximize();

        driver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");
    }
    @After
    public void Finish(){
//        driver.quit();
    }


}
