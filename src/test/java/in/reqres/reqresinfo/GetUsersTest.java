package in.reqres.reqresinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetUsersTest extends TestBase {

    @Test
    public void getAllUsers() {
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/users");
        response.then().statusCode(200);

        //Test
        int page = response.then().extract().path("page");
        System.out.println("Test 1. Page is       :" + page);

        int perPage = response.then().extract().path("per_page");
        System.out.println("Test 2. Per Page      :" + perPage);

        int id = response.then().extract().path("data[1].id");
        System.out.println("Test 3. ID of Data 1  :" + id);

        String firstName = response.then().extract().path("data[3].first_name");
        System.out.println("Test 4. First name    :" + firstName);

        List<?> listOfData = response.then().extract().path("data");
        System.out.println("Test 5. List of Data  :" + listOfData.size());

        String avatar = response.then().extract().path("data[5].avatar");
        System.out.println("Test 6. Avatar        :" + avatar);

        String supportUrl = response.then().extract().path("support.url");
        System.out.println("Test 7. Support URL   :" + supportUrl);

        String supportText = response.then().extract().path("support.text");
        System.out.println("Test 8. Support Text  :" + supportText);

        System.out.println("----------Response body----------");
        response.prettyPrint();

    }

    @Test
    public void getSingleUser() {
        Response response = given()
                .pathParam("id", 4)
                .when()
                .get("/users/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
