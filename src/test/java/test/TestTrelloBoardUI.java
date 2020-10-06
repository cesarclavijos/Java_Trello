package test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.*;


public class TestTrelloBoardUI extends TestBaseUI {
    private static LoguinPage loguinPage =new LoguinPage(driver) ;
    private static ResultPage resultPage =new ResultPage(driver) ;
    private static BoardPage boardPage =new BoardPage(driver) ;
    private static CardPage cardPage =new CardPage(driver) ;


    @BeforeClass
    public static void  TrelloLoguin()  throws InterruptedException {
        loguinPage.loguinTrello();
        resultPage.SelectBoard();

    }


    @Test
    public void AddCard() throws InterruptedException {
        int TotalTicketInProgress = boardPage.CountTicketsInTodo();
        boardPage.CreateaCard();
        assert TotalTicketInProgress < boardPage.CountTicketsInTodo();

    }

    @Test
    public void AddComent() throws InterruptedException {
        boardPage.SelectFirstItemInToDo();
        cardPage.AddDescription();
        String TextCard = cardPage.Description();
        assert TextCard != null ;
    }


    @Test
    public void MovetoInProgress() throws InterruptedException {
        boardPage.SelectFirstItemInToDo();
        int TotalTicketInProgress = boardPage.CountTicketsInProgress();
        cardPage.MovetoInProgress();
        assert TotalTicketInProgress < boardPage.CountTicketsInProgress();
    }

    @Test
    public void MovetoDone() throws InterruptedException {
        boardPage.SelectFirstItemInProgress();
        int TotalTicketInProgress = boardPage.CountTicketsInDone();
        cardPage.MovetoInDone();
        assert TotalTicketInProgress < boardPage.CountTicketsInDone();
    }










}
