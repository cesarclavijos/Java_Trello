package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


public class LoguinPage extends basepage {


    private String ConfigUsername = "cesar_hcs@hotmail.com";
    private String ConfigPassword = "Test1234";

    @FindBy(id = "user")
    private WebElement UserField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login")
    private WebElement loginButton;

    private final By ErrorMessages = By.id("error");


    public LoguinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loguinTrello(){
        UserField.sendKeys(ConfigUsername);
        passwordField.sendKeys(ConfigPassword);
        loginButton.click();
    }

    public void loguinTrelloFail(){
        UserField.sendKeys();
        passwordField.sendKeys();
        loginButton.click();
    }

    public String FailedAccess()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessages));
        String ErrorMessage = driver.findElement(ErrorMessages).getText();
        return ErrorMessage;
    }



}
