package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBar extends basepage {

    @FindBy(id = "ccPDcplbZV5LR4oEdSZXJ5YBr4ODLQKm")
    private WebElement searchfield;
    @FindBy(css = "._1aTEN2k6mbGXDt > .sc-bdVaJa")
    private WebElement searchButton;
    @FindBy(id = "header")
    private WebElement searchHeader;
    @FindBy(css = ".MEu8ZECLGMLeab")
    private WebElement Boards;
    @FindBy(xpath = "//*[contains(text(), '¡Bienvenido a Trello!')]")
    private WebElement BoardTrello;


    public SearchBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SearchByKeyword(String arg1){
        searchfield.sendKeys(arg1);
        searchButton.click();
    }

    public void SelectBoard(){
        Boards.click();
        BoardTrello.click();
    }

    public WebElement ReturnHeader(){
       return searchHeader;
    }


}
