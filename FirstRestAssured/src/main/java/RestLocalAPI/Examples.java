package RestLocalAPI;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Examples {

    @Test
    public void test_get(){

        baseURI = "http://localhost:3000/";

//url = "http:localhost:3000/users"
        given().
                get("/users").
                then().
                statusCode(200).
                log().all();

//url = "http://localhost:3000/subjects?name=Automation"
        given().
                param("name", "Automation").
                get("/subjects").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_post(){
        JSONObject request = new JSONObject();

        request.put("firstName", "Tom");
        request.put("lastName", "Barkley");
        request.put("subjectId", 1);
        request.put("id", 5);

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

    @Test
    public void test_put(){
        JSONObject request = new JSONObject();

        request.put("firstName", "Tom");
        request.put("lastName", "Barkley");
        request.put("subjectId", 1);
        request.put("id", 5);

        baseURI = "http://localhost:3000/";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().put("/users/5").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_patch(){
        JSONObject request = new JSONObject();

        request.put("firstName", "Harry");
        request.put("lastName", "Style");
        request.put(" subjectId", 1);
        request.put("id", 5);

        baseURI = "http://localhost:3000/";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().patch("/users/5").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_delete(){

        baseURI = "http://localhost:3000";

        given().
                delete("/users/5").
                then().
                statusCode(200).
                log().all();
    }
}
