package day05;

import base_urls.petsurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static utlities.ObjectMapperUtilities.convertJsonToJava;

public class HW1 extends petsurl {

    //Write an automation test that will create a '
    // user' then read, update and delete the created
    // user using the "https://petstore.swagger.io/" document.
    // (Create a classes for each request.)
@Test
public void test(){
    spec.pathParam("first","user");

    String expectedStr = """
                {"id": 0,
                                             "username": "FatimahAH",
                                             "firstName": "Fatimah",
                                             "lastName": "Alhuzaymi",
                                             "email": "fatimahalhuzaymi@gmail.com",
                                             "password": "AFH8764",
                                             "phone": "05532198056",
                                             "userStatus": 0
                          }
               
                 }""";
    Map<String,Object> payLoad = convertJsonToJava(expectedStr,Map.class);
    Response response = given(spec).body(payLoad).when().post("{first}");
    response.prettyPrint();

    response
            .then()
            .statusCode(200)
            .body("Code",equalTo(200), "type",equalTo(""));


     Response getResponse = given(spec).when().get("{first}/"+payLoad.get("username"));
     getResponse.prettyPrint();

     Map<String,Object> actualData = convertJsonToJava(getResponse.asString(),Map.class);

     assertEquals(actualData.get("username"),payLoad.get("username"));
     assertEquals(actualData.get("firstName"),payLoad.get("firstName"));
     assertEquals(actualData.get("lastName"),payLoad.get("lastName"));
     assertEquals(actualData.get("email"),payLoad.get("email"));
     assertEquals(actualData.get("password"),payLoad.get("password"));
     assertEquals(actualData.get("phone"),payLoad.get("phone"));



     Response deleteResponse = given(spec).when().delete("{first}/"+payLoad.get("username"));
     deleteResponse.prettyPrint();

     deleteResponse
             .then()
             .statusCode(200);
}



}



