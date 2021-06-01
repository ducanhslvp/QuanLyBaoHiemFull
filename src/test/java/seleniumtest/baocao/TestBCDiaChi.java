package seleniumtest.baocao;

import com.detai10.qlbhxh.controller.dao.TaiKhoanDAO;
import com.detai10.qlbhxh.controller.impl.TaiKhoanDAOImpl;
import com.detai10.qlbhxh.model.TaiKhoan;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestBCDiaChi {

    static WebDriver chromeDriver;
    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();

    @Test
    public void bcDiaChiTitleTest() {
        System.setProperty("webdriver.chrome.driver",
                "D:\\HOC TAP\\NAM 4 KY 2\\Dam bao chat luong phan mem\\DEMO\\Webdriver Chrome\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");

        WebElement txt1 = chromeDriver.findElement(By.name("username"));
        txt1.sendKeys("tuananh");
        chromeDriver.findElement(By.name("password")).sendKeys("123");
        chromeDriver.findElement(By.cssSelector("button.btn")).click();

        chromeDriver.findElement(By.linkText("BÁO CÁO")).click();
        chromeDriver.findElement(By.cssSelector("a[href^=bcDiaChi]")).click();

        String title = chromeDriver.getTitle();
        String expectedTitle = "Báo cáo theo địa chỉ";
        assertEquals(title, expectedTitle, "Tiêu đề không khớp");
        chromeDriver.close();
    }

    @Test
    public void testgetListDiaChi(){
        System.setProperty("webdriver.chrome.driver",
                "D:\\HOC TAP\\NAM 4 KY 2\\Dam bao chat luong phan mem\\DEMO\\Webdriver Chrome\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");

        WebElement txt1 = chromeDriver.findElement(By.name("username"));
        txt1.sendKeys("tuananh");
        chromeDriver.findElement(By.name("password")).sendKeys("123");
        chromeDriver.findElement(By.cssSelector("button.btn")).click();

        chromeDriver.findElement(By.linkText("BÁO CÁO")).click();
        chromeDriver.findElement(By.cssSelector("a[href^=bcDiaChi]")).click();

        List<String> listDiaChi= taiKhoanDAO.getListDiaChi();
        for(String list:listDiaChi)
            System.out.println(list);

        chromeDriver.close();
    }

    @Test
    public void bcDiaChiHaNoiTitleTest() {
        System.setProperty("webdriver.chrome.driver",
                "D:\\HOC TAP\\NAM 4 KY 2\\Dam bao chat luong phan mem\\DEMO\\Webdriver Chrome\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");

        WebElement txt1 = chromeDriver.findElement(By.name("username"));
        txt1.sendKeys("tuananh");
        chromeDriver.findElement(By.name("password")).sendKeys("123");
        chromeDriver.findElement(By.cssSelector("button.btn")).click();

        chromeDriver.findElement(By.linkText("BÁO CÁO")).click();
        chromeDriver.findElement(By.cssSelector("a[href^=bcDiaChi]")).click();
        List<WebElement> elements = chromeDriver.findElements(By.cssSelector("a[class$=secondary]"));
        elements.get(1).click();

        String title = chromeDriver.getTitle();
        String expectedTitle = "Báo cáo theo địa chỉ";
        assertEquals(title, expectedTitle, "Tiêu đề không khớp");
        chromeDriver.close();
    }

    @Test
    public void bcDiaChiHaNoiDetailTitleTest(){
        System.setProperty("webdriver.chrome.driver",
                "D:\\HOC TAP\\NAM 4 KY 2\\Dam bao chat luong phan mem\\DEMO\\Webdriver Chrome\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("http://localhost:8080/QuanLyBaoHiem_war_exploded/");

        WebElement txt1 = chromeDriver.findElement(By.name("username"));
        txt1.sendKeys("tuananh");
        chromeDriver.findElement(By.name("password")).sendKeys("123");
        chromeDriver.findElement(By.cssSelector("button.btn")).click();

        chromeDriver.findElement(By.linkText("BÁO CÁO")).click();
        chromeDriver.findElement(By.cssSelector("a[href^=bcDiaChi]")).click();
        List<WebElement> elements = chromeDriver.findElements(By.cssSelector("a[class$=secondary]"));
        elements.get(1).click();

        List<WebElement> element1 = chromeDriver.findElements(By.cssSelector("a[class$=secondary]"));
        element1.get(3).click();

        String title = chromeDriver.getTitle();
        String expectedTitle = "Xem thông tin chi tiết bảo hiểm khách hàng";
        assertEquals(title, expectedTitle, "Tiêu đề không khớp");
        chromeDriver.close();
    }
}
