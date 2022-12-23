package DataDrivenExamples;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;

public class Example1 extends DataForTest {
//    @Test(dataProvider = "DataForPost")
    public void test_post(String firstName, String lastName, int subjectId){

        JSONObject request = new JSONObject();

        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().post("/users").
                then().
                statusCode(201).
                log().all();
    }

//    @Test(dataProvider = "DataForDelete")
    public void test_delete(int usreId){

        baseURI = "http://localhost:3000";

        given().
                delete("/users/"+usreId).
                then().
                statusCode(200).
                log().all();
    }

    @Parameters({"userId"})
    @Test
    public void test_delete_parameter(int userId){
        System.out.println("Value for userId is : " + userId);
        baseURI = "http://localhost:3000";

        given().
                delete("/users/"+userId).
                then().
                statusCode(200).
                log().all();
    }
}
