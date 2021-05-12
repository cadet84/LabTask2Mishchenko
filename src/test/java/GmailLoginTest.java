import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.*;
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
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]")).click();
    String originalWindow = driver.getWindowHandle();
    //WebDriverWait wait = new WebDriverWait(driver,15);
        for (String windowHandle : driver.getWindowHandles()
             ){
            if (!originalWindow.contentEquals(windowHandle)){
                driver.switchTo().window(windowHandle);
                break;
            }

        }
    driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("mishchenkotest1");
    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
    }
}
