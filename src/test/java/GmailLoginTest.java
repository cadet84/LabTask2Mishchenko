import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailLoginTest {
    private WebDriver driver;
    private String url = "https://www.google.com/intl/en/gmail/about/";

    @BeforeSuite
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("the set up is complete");
    }

    @Test
    public void GmailLogin(){
    driver.get(url);
    }
}
