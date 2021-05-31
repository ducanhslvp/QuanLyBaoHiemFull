package seleniumtest.logintest;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {
    private String driverUrl = "D:\\HOC TAP\\NAM 4 KY 2\\Dam bao chat luong phan mem\\DEMO\\Webdriver Chrome\\chromedriver.exe";

    public TestDriver() {
    }

    public ChromeDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", driverUrl);
        return new ChromeDriver();
    }
}
