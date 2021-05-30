package seleniumtest.cauhinh;

import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl;
import com.detai10.qlbhxh.controller.servlet.GoiBaoHiemServlet;
import com.detai10.qlbhxh.model.GoiBaoHiem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestAddGoiBH {
    private WebDriver driver;
    private GoiBaoHiemDAO goiBaoHiemDAO=  new GoiBaoHiemDAOImpl();

    @Test
    public void TestAddOk(){
            driver.findElement(By.name("ten")).sendKeys("Goi BH 1");
            driver.findElement(By.name("tien")).sendKeys("999999");
            driver.findElement(By.name("thoiGian")).sendKeys("36");
            driver.findElement(By.cssSelector("button[class$=success]")).click();
    }
    @Test
    public void TestAddKyTuDacBiet(){
        driver.findElement(By.name("ten")).sendKeys("%^##^$@^$@$@^#@^");
        driver.findElement(By.name("tien")).sendKeys("999999");
        driver.findElement(By.name("thoiGian")).sendKeys("36");
        driver.findElement(By.cssSelector("button[class$=success]")).click();
    }
    @Test
    public void TestAddBoTrongCacTruong(){

        driver.findElement(By.cssSelector("button[class$=success]")).click();
    }
    @Test
    public void TestAddNhapTienLaText(){
            driver.findElement(By.name("ten")).sendKeys("Goi BH %$$@#$@&^%*^%&$^%#");
            driver.findElement(By.name("tien")).sendKeys("zdgfsdhf");
            driver.findElement(By.name("thoiGian")).sendKeys("36");
            driver.findElement(By.cssSelector("button[class$=success]")).click();
    }
    @Test
    public void TestAddNhapThangLaText(){
        driver.findElement(By.name("ten")).sendKeys("Goi BH 1");
        driver.findElement(By.name("tien")).sendKeys("999999");
        driver.findElement(By.name("thoiGian")).sendKeys("sdhss");
        driver.findElement(By.cssSelector("button[class$=success]")).click();
    }
    @Test
    public void TestAddNhapTienAm(){
        driver.findElement(By.name("ten")).sendKeys("Goi BH 1");
        driver.findElement(By.name("tien")).sendKeys("-1");
        driver.findElement(By.name("thoiGian")).sendKeys("999");
        driver.findElement(By.cssSelector("button[class$=success]")).click();
    }
    @Test
    public void TestAddNhapThangAm(){
        driver.findElement(By.name("ten")).sendKeys("Goi BH 1");
        driver.findElement(By.name("tien")).sendKeys("0");
        driver.findElement(By.name("thoiGian")).sendKeys("-1");
        driver.findElement(By.cssSelector("button[class$=success]")).click();
    }
    @Test
    public void TestAddNhapThangSoThapPhan(){
        driver.findElement(By.name("ten")).sendKeys("Goi BH 1");
        driver.findElement(By.name("tien")).sendKeys("9999");
        driver.findElement(By.name("thoiGian")).sendKeys("5.6");
        driver.findElement(By.cssSelector("button[class$=success]")).click();
    }
    @Test
    public void TestAddNhapTienSoThapPhan(){
        driver.findElement(By.name("ten")).sendKeys("Goi BH 1");
        driver.findElement(By.name("tien")).sendKeys("99.5");
        driver.findElement(By.name("thoiGian")).sendKeys("999");
        driver.findElement(By.cssSelector("button[class$=success]")).click();
    }
    @Test
    public void TestUpdateNhapTienQuaLon(){
        driver.findElement(By.name("ten")).sendKeys("Goi BH 1");
        driver.findElement(By.name("tien")).sendKeys("999999999999999999999");
        driver.findElement(By.name("thoiGian")).sendKeys("999");
        driver.findElement(By.cssSelector("button[class$=success]")).click();
    }
    @Test
    public void TestUpdateNhapThangQuaLon(){
        driver.findElement(By.name("ten")).sendKeys("Goi BH 1");
        driver.findElement(By.name("tien")).sendKeys("99.5");
        driver.findElement(By.name("thoiGian")).sendKeys("99999999999999999999999999");
        driver.findElement(By.cssSelector("button[class$=success]")).click();
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

        driver.findElement(By.cssSelector("a[href^=cauhinh]")).click();
        driver.findElement(By.cssSelector("a[href^=addGoiBH]")).click();

        System.out.println("Before: ");
        List<GoiBaoHiem> listGoiBH =goiBaoHiemDAO.getListGoiBH();
        for (GoiBaoHiem goiBaoHiem:listGoiBH)
            System.out.println(goiBaoHiem.toString());
    }
    @After
    public void Finish(){
        System.out.println("After: ");
        List<GoiBaoHiem> listGoiBH =goiBaoHiemDAO.getListGoiBH();
        for (GoiBaoHiem goiBaoHiem:listGoiBH)
            System.out.println(goiBaoHiem.toString());

//        driver.quit();
    }
}
