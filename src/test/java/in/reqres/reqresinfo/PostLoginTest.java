package in.reqres.reqresinfo;

import in.reqres.model.ReqresPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostLoginTest extends TestBase {
    @Test
    public void loginSuccessfulTest(){
        ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setEmail("eve.holt@reqres.in");
        reqresPojo.setPassword("PrimeCheck");

        Response response = given()
                .header("Content-Type","application/json")
                .body(reqresPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
