package restapi;
//import entities.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;



public class RequestApi {
    private String  URL;
    private String user;
    private String password;
    private String response;

    public RequestApi(String URL){this.URL = URL;}

    public Response GetMessage(String endpoint){
        return given().contentType(ContentType.JSON).
                when().get(this.URL + endpoint).
                andReturn();

    }


    public Response PostMessage(String endpoint){
        return given().contentType(ContentType.JSON).
                when().post(this.URL+endpoint).
                andReturn();
    }

    public Response Delete(String endpoint){
        return given().contentType(ContentType.JSON).
                when().delete(this.URL+endpoint).
                andReturn();
    }

    public Response PutUpdateCard(String endpoint){
        return given().contentType(ContentType.JSON).
                param("name", "Testcard").
                when().put(this.URL+endpoint).
                andReturn();
    }

    private static String payload = "{\n" +
            "  \"value\": \"5f3db806304a1d2280ad348c\"\n"+
            "}";

    public Response PostAddMember(String endpoint){
        return given().contentType(ContentType.JSON).
                body(payload).
                when().log().all().post(this.URL+endpoint).
                andReturn();
    }



}
