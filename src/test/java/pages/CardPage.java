package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardPage  extends basepage {

    @FindBy(xpath = "//*[contains(text(), 'Añadir una descripción más detallada...')]")
    private WebElement DescriptionField;
    @FindBy(xpath = "//*[@class='field field-autosave js-description-draft description card-description']")
    private WebElement Descriptiontext;
    @FindBy(className = "button subtle hide-on-edit js-show-with-desc js-edit-desc js-edit-desc-button")
    private WebElement DescriptionWithText;
    @FindBy(css = ".mod-submit-edit")
    private WebElement SaveButton;
    @FindBy(xpath = "//*[contains(text(), 'test')]")
    private WebElement Texto;
    @FindBy(xpath = "//*[contains(text(), 'Mover')]")
    private WebElement MovButton;
    @FindBy(css = ".js-select-list")
    private WebElement List;
    @FindBy(css = "option[label='En proceso']")
    private WebElement inProgressOption;
    @FindBy(xpath = "//*[@class='primary wide js-submit']")
    private WebElement MoveAccepted;
    @FindBy(css = ".icon-md")
    private WebElement CloseWindow;



    public CardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AddDescription(){
        if (Descriptiontext.isDisplayed() == true)
        {
            DescriptionField.click();
        }
        else{
            DescriptionWithText.click();
        }
        Descriptiontext.sendKeys("Test");
        SaveButton.click();
    }

    public String Description(){
        return Texto.getText();
    }

    public void MovetoInProgress(){
        MovButton.click();
        List.click();
        //inProgressOption.click();
        List.sendKeys("En");
        List.sendKeys(Keys.ENTER);
        MoveAccepted.click();
        CloseWindow.click();
    }

    public void MovetoInDone(){
        MovButton.click();
        List.click();
        //inProgressOption.click();
        List.sendKeys("hecho");
        List.sendKeys(Keys.ENTER);
        MoveAccepted.click();
        CloseWindow.click();
    }







}
