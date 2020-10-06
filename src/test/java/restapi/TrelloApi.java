package restapi;

import helper.ApiVariable;
import io.restassured.response.Response;
//import entities.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.Random;

import static helper.ApiVariable.CardId;

public class TrelloApi {

    private static TrelloApi api;
    private final String url;
    private final RequestApi httpMessageSender;
    private Gson gson = new Gson();
    private JsonParser parser = new JsonParser();
    private String key = ApiVariable.GetKey();
    private String token = ApiVariable.GetToken();

    public TrelloApi(String urlApi){
        this.url = urlApi;
        httpMessageSender = new RequestApi(urlApi);
    }


    public Response PostCreateBoard() {
        Response response = httpMessageSender.PostMessage("boards/?key="+key+"&token="+token+"&name=Boardtest");
        return response;

    }

    public Response PostCreateBoardError() {
        Response response = httpMessageSender.PostMessage("boards/?key="+key+"1&token="+token+"&name=Boardtest");
        return response;

    }

    public Response GetBoardinformation() {
        Response response = httpMessageSender.GetMessage("members/me/boards?fields=name,url&key="+key+"&token="+token);
        return response;

    }


    public Response GetMembersinformation() {
        Response responseGet = GetBoardinformation();
        JsonPath jsonPathEvaluator = responseGet.jsonPath();
        String BoardId = jsonPathEvaluator.get("id[0]");
        Response response = httpMessageSender.GetMessage("boards/"+BoardId+"/members?key="+key+"&token="+token);
        return response;

    }

    public Response DeleteBoard() {
        Response responsePost = PostCreateBoard();
        JsonPath jsonPathEvaluator = responsePost.jsonPath();
        String BoardId = jsonPathEvaluator.get("id");
        Response response = httpMessageSender.Delete("boards/"+BoardId+"?key="+key+"&token="+token);
        return response;

    }

    public Response PostCreateCard() {
        Response response = httpMessageSender.PostMessage("cards?key="+key+"&token="+token+"&idList=5f72a6dd6cdbb46e3fd13032");
        JsonPath jsonPathEvaluator = response.jsonPath();
        CardId= jsonPathEvaluator.get("id");
        return response;
    }

    public Response UpdateCard() {
        Response response = httpMessageSender.PutUpdateCard("cards/"+ApiVariable.GetCardId()+"?key="+key+"&token="+token);
        return response;
    }

    public Response AddComment() {
        Response response = httpMessageSender.PostMessage("cards/"+ApiVariable.GetCardId()+"/actions/comments?key="+key+"&token="+token+"&text=Text Comment");
        return response;
    }

    public Response AddMember() {
        Response response = httpMessageSender.PostAddMember("cards/"+ApiVariable.GetCardId()+"/idMembers?key="+key+"&token="+token);
        ResponseBody body = response.getBody();

        // By using the ResponseBody.asString() method, we can convert the  body
        // into the string representation.
        System.out.println("Response Body is: " + body.asString());
        return response;
    }


    public Response DeleteCard() {
        String CardId= ApiVariable.GetCardId();
        Response response = httpMessageSender.Delete("cards/"+CardId+"?key="+key+"&token="+token);
        return response;

    }


    public static int GetRandomNumber(){
        int min = 1;
        int max = 50;
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }

    public String StatusMessage(Response response){
        JsonPath jsonPathEvaluator = response.jsonPath();
        return jsonPathEvaluator.get("status_message");
    }

    public String IdCreated(Response response){
        JsonPath jsonPathEvaluator = response.jsonPath();
        return jsonPathEvaluator.get("id");
    }

}
