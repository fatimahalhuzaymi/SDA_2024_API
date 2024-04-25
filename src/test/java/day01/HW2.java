package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class HW2 {
      /*
        Given

        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        Andhttps://reqres.in/api/users/23
            Response body should be empty
     */



    @Test
    void hw1() {
//
        String url = "https://reqres.in/api/users/23";
        //        User sends a GET Request to the URLHTTP/1.1 200 OK
        Response response = given().when().get(url);
        response.prettyPrint();

        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server","cloudflare")
                .body("[0]",equalTo(null));

    }
}
