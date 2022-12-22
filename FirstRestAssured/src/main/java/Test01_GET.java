import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01_GET {
    public static void main(String[] args) {

    }

    @Test
     void test_01(){
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.asString());
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    void test_02(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body();
    }
}
