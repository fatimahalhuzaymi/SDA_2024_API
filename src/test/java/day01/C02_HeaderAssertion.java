package day01;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.urlEncodingEnabled;

public class C02_HeaderAssertion {

    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    And
        Connection should be keep-alive
*/


    //Response response = given().when().get(Url);
    //response.prettyPrint();





    @Test
    public void headerTest(){

        //while doing api test you can follow the following 4 steps:
        // Set Url
        String Url = "https://restful-booker.herokuapp.com/booking";
        //Set expected data (if we expected data in certain format) or payload (if we use put or post)

        //// Sent request and get response

        //given()
                //.when()
              //  .get(Url)
                //.statusLine(200)
                //.contentType("application/json")
                //.statusLine("HTTP/1.1 200")
                //.header("Connection","keep-alive");

        //// Do assertions


    }
}

