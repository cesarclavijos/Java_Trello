package test;

import helper.ApiVariable;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang.ObjectUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import restapi.TrelloApi;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class TestBoardApi {
    private static TrelloApi api;
    private static io.restassured.specification.ResponseSpecification ResponseSpecification;

// mvn surefire-report:report -DshowSuccess=false

    private io.restassured.specification.ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .build();

    @BeforeClass
    public static void createrequestspecification2(){
        api = new TrelloApi(ApiVariable.GetUrl());

    }



    @Test
    public void CheckCreationBoard() {
        Response response = api.PostCreateBoard();
        response.then().
                assertThat().
                spec(responseSpec).
                body("id", is(notNullValue()));

    }


    @Test
    public void CheckKeyErrorCreationBoard() {
        Response response = api.PostCreateBoardError();
        response
                .then()
                .assertThat()
                .statusCode(401);
    }


    @Test
    public void CheckBoardInformation() {
        Response response = api.GetMembersinformation();
        response
                .then()
                .assertThat()
                .spec(responseSpec)
                .body("username[0]", containsString("cesarclavijosanchez"));
    }

    @Test
    public void DeleteBoard() {
        Response response = api.DeleteBoard();
        response
                .then()
                .assertThat()
                .spec(responseSpec)
                .body("_value",equalTo(null) );
    }

}
