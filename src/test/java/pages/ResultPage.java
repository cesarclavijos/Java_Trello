package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends SearchBar  {

    @FindBy(css = "_1aTEN2k6mbGXDt > .sc-bdVaJa")
    private WebElement BoardTest;


    public ResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Selectboard2(){
        BoardTest.click();

    }


}
