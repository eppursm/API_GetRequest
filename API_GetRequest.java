package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class API_GetRequest {

    @Test
    public void get01(){

        //1- Request URL ve Body oluştur!
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        //2- Expected Data oluştur!
        JSONObject expBody = new JSONObject();
        expBody.put("userId",1);
        expBody.put("title","sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        expBody.put("body","quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");

        //3- Response'u kaydet!
        Response response = given().when().get(url);

        //4- Assertion oluştur!
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        JsonPath actBody = response.jsonPath();

        Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));
        Assert.assertEquals(expBody.get("title"),actBody.get("title"));





    }
}
