import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Test_POST {

    @Test
    public void test_POST(){

//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "docu");
//        map.put("job", "Learner");
//        System.out.println(map);
//        JSONObject request = new JSONObject(map);

        JSONObject request = new JSONObject();
        request.put("name", "docu");
        request.put("job", "Learner");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(201);
    }
}
