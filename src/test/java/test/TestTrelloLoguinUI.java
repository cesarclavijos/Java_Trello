package test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestTrelloLoguinUI extends TestBaseUI {
    private static LoguinPage loguinPage =new LoguinPage(driver) ;
    private static HomePage homePage =new HomePage(driver) ;

    @Test
    public void CheckLoguin() throws InterruptedException {
        loguinPage.loguinTrello();
        assertTrue(homePage.ReturnHeader().isDisplayed());
    }

    @Test
    public void IncorrectLoguin() throws InterruptedException {
        loguinPage.loguinTrelloFail();
        String message = loguinPage.FailedAccess();
        assertEquals(message,"Falta el correo electrónico");
    }

}
