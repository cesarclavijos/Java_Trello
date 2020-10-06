package test;

import helper.ApiVariable;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import restapi.TrelloApi;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TestCardApi {
    private static TrelloApi api;
    private static io.restassured.specification.ResponseSpecification ResponseSpecification;

    private io.restassured.specification.ResponseSpecification responseSpec2 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .build();


    @BeforeClass
    public static void CreateRequestSpecification(){
        api = new TrelloApi(ApiVariable.GetUrl());
        Response response = api.PostCreateCard();
        response
                .then()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void Updatedcard() {
        Response response = api.UpdateCard();
        response
                .then()
                .assertThat()
                .spec(responseSpec2)
                .body("name", containsString("Testcard"));
    }


    @Test
    public void AddComent() {
        Response response = api.AddComment();
        response
                .then()
                .assertThat()
                .spec(responseSpec2)
                .body("data.text", containsString("Text Comment"));
    }


    @Test
    public void AddMemberToCard() {
        Response response = api.AddMember();
        response
                .then()
                .assertThat()
                .spec(responseSpec2)
                .body("username[0]", containsString("cesarclavijosanchez"))
                .body("fullName[0]", containsString("CESAR CLAVIJO SANCHEZ"))
                .body("initials[0]", containsString("CS"));
    }


    @AfterClass
    public static void DeleteCards(){
        Response response = api.DeleteCard();
        response
                .then()
                .assertThat()
                .statusCode(200);

    }




}
