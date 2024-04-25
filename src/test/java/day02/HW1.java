package day02;

import base_urls.RestFullBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HW1 extends RestFullBaseUrl {
/*
       Given
           https://reqres.in/api/users/2

       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           "email" is "janet.weaver@reqres.in",
       And
           "first_name" is "Janet"
       And
           "last_name" is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */
    @Test
    public void hw() {

        spec.pathParam("first","users");

        Response response = given(spec).when().get("{first}");
        response.prettyPrint();


        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email",equalTo("janet.weaver@reqres.in"),
                        "data.first_name",equalTo("Janet"),
                        "data.last_name",equalTo("Weaver"),
                        "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        JsonPath json = response.jsonPath();

        String email = json.getString("data,email");
        String firstname = json.getString("data.first_name");
        String lastname = json.getString("data.last_name");
        String text = json.getString("support.text");

        assertEquals("janer.wever@reqres.in",email);
        assertEquals("janet",firstname);
        assertEquals("weaver",lastname);
        assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",text);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("janer.wever@reqres.in",email);
        softAssert.assertEquals("janet",firstname);
        softAssert.assertEquals("weaver",lastname);
        softAssert.assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",text);

        softAssert.assertAll();




    }
}

