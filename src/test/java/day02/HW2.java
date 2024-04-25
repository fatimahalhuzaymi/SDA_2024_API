package day02;

import base_urls.RestFullBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HW2 extends RestFullBaseUrl {


    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json; charset=utf-8"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void hw2(){
        spec.pathParams("first","unknown","second",3);
        Response response= given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id",equalTo(3)
                        ,"data.name",equalTo("true red")
                        ,"data_year",equalTo("2002")
                        ,"data_color",equalTo("#BF1932")
                        ,"data_pantone",equalTo("19-1664")
                        ,"support_url",equalTo("https://reqres.in/#support-heading")
                        ,"support_text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));



    }



}

