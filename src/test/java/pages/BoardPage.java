package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BoardPage extends SearchBar  {


    @FindBy(xpath = "(//*[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable'][1]/*[1])[1]")
    private WebElement FirstElement;
    @FindBy(xpath = "(//*[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable'][1]/*[1])[2]")
    private WebElement FirstElementInProgress;
    @FindBy(xpath = "(//*[@class='open-card-composer js-open-card-composer'])[1]")
    private WebElement CreateButton;
    @FindBy(xpath = "(//*[@class='list-card-composer-textarea js-card-title'])")
    private WebElement Text;


    private final By TicketsInToDo = By.xpath("(//*[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable'])[1]");
    private final By TicketsInProgress = By.xpath("(//*[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable'])[2]");
    private final By TicketsInDone = By.xpath("(//*[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable'])[3]");

    public BoardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void CreateaCard(){
        CreateButton.click();
        Text.sendKeys("Test");
        Text.sendKeys(Keys.ENTER);
    }

    public void SelectFirstItemInToDo(){
        FirstElement.click();
    }

    public void SelectFirstItemInProgress(){
        FirstElementInProgress.click();
    }

    public int CountTicketsInTodo(){
        return Countelements(TicketsInToDo);
    }

    public int CountTicketsInProgress(){
        return Countelements(TicketsInProgress);
    }

    public int CountTicketsInDone(){
        return Countelements(TicketsInDone);
    }

    public int Countelements(By Element){
        WebElement tickets = driver.findElement(Element);
        int numberOfChilds = Integer.parseInt(tickets.getAttribute("childElementCount"));
        return numberOfChilds;
    }
}
