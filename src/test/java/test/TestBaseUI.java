package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class TestBaseUI {

    protected static  WebDriver driver;

    @BeforeClass
    public static void beforeSuite() {

        final String URL_STRING = "https://trello.com/login";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cclavijo\\OneDrive - ENDAVA\\Documents\\Java\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL_STRING);
    }

    public WebDriver getWebDriver(){
        return this.driver;
    }


    /*@AfterClass
    public static void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }*/

}
