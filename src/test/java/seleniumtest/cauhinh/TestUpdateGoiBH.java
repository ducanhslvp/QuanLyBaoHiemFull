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

public class TestUpdateGoiBH {
    private WebDriver driver;
    private GoiBaoHiemServlet goiBaoHiemServlet=new GoiBaoHiemServlet();
    private GoiBaoHiemDAO goiBaoHiemDAO=  new GoiBaoHiemDAOImpl();

    @Test
    public void TestUpdateOk(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();
            driver.findElement(By.name("ten")).sendKeys("Goi BH 1");

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("999999");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("36");

            driver.findElement(By.cssSelector("button[class$=success]")).click();
        }finally {
        }
    }
    @Test
    public void TestUpdateKyTuDacBiet(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();
            driver.findElement(By.name("ten")).sendKeys("Goi BH %$$@#$@&^%*^%&$^%#");

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("999999");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("36");

            driver.findElement(By.cssSelector("button[class$=success]")).click();
        }finally {
        }
    }
    @Test
    public void TestUpdateBoTrongCacTruong(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("999999");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("36");

            driver.findElement(By.cssSelector("button[class$=success]")).click();
        }finally {
        }
    }
    @Test
    public void TestUpdateNhapTienLaText(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();
            driver.findElement(By.name("ten")).sendKeys("Goi BH %$$@#$@&^%*^%&$^%#");

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("zdgfsdhf");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("36");

            driver.findElement(By.cssSelector("button[class$=success]")).click();
        }finally {
        }
    }
    @Test
    public void TestUpdateNhapThangLaText(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();
            driver.findElement(By.name("ten")).sendKeys("Goi BH %$$@#$@&^%*^%&$^%#");

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("55599");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("sdfsdfsdf");

            driver.findElement(By.cssSelector("button[class$=success]")).click();
        }finally {
        }
    }
    @Test
    public void TestUpdateNhapTienAm(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();
            driver.findElement(By.name("ten")).sendKeys("Goi BH %$$@#$@&^%*^%&$^%#");

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("-1");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("99999");

            driver.findElement(By.cssSelector("button[class$=success]")).click();
        }finally {
        }
    }
    @Test
    public void TestUpdateNhapThangAm(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();
            driver.findElement(By.name("ten")).sendKeys("Goi BH %$$@#$@&^%*^%&$^%#");

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("99999");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("-1");

            driver.findElement(By.cssSelector("button[class$=success]")).click();


        }finally {
        }
    }
    @Test
    public void TestUpdateNhapTienSoThapPhan(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();
            driver.findElement(By.name("ten")).sendKeys("Goi BH %$$@#$@&^%*^%&$^%#");

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("999.9");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("-1");

            driver.findElement(By.cssSelector("button[class$=success]")).click();


        }finally {
        }
    }
    @Test
    public void TestUpdateNhapThangSoThapPhan(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();
            driver.findElement(By.name("ten")).sendKeys("Goi BH %$$@#$@&^%*^%&$^%#");

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("99999");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("36.5");

            driver.findElement(By.cssSelector("button[class$=success]")).click();


        }finally {
        }
    }
    @Test
    public void TestUpdateNhapTienQuaLon(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();
            driver.findElement(By.name("ten")).sendKeys("Goi BH %$$@#$@&^%*^%&$^%#");

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("999999999999999999999999");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("999");

            driver.findElement(By.cssSelector("button[class$=success]")).click();
        }finally {
        }
    }
    @Test
    public void TestUpdateNhapThangQuaLon(){
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[class$=dark]"));
            elements.get(0).click();

            driver.findElement(By.name("ten")).clear();
            driver.findElement(By.name("ten")).sendKeys("Goi BH %$$@#$@&^%*^%&$^%#");

            driver.findElement(By.name("tien")).clear();
            driver.findElement(By.name("tien")).sendKeys("99999");

            driver.findElement(By.name("thoiGian")).clear();
            driver.findElement(By.name("thoiGian")).sendKeys("99999999999999999999999999");

            driver.findElement(By.cssSelector("button[class$=success]")).click();
        }finally {
        }
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
