package in.reqres.reqresinfo;

import in.reqres.model.ReqresPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostCreateUserTest extends TestBase {

    @Test
    public void createUser(){
        ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setJob("Electrician");
        reqresPojo.setName("Queen W");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(reqresPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }

}
