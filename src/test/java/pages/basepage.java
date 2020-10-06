package pages;

import test.TestBaseUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class  basepage  {

    protected  WebDriver driver ;

    protected WebDriverWait wait = new WebDriverWait(new TestBaseUI().getWebDriver(),20);

    protected void sendKeysToElement(String input, WebElement element) throws InterruptedException {
        element.sendKeys(input);
    }


}
