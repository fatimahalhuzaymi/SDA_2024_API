package day05.HW;

import base_urls.hwd5url;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utlities.ObjectMapperUtilities.convertJsonToJava;

public class UpdateRequest extends hwd5url {

@Test
public void test() throws JsonProcessingException {
    spec.pathParams("first","user","second","FatimahAH");


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
    Response response = given(spec).body(payLoad).when().post("{first}/{second}");
    response.prettyPrint();

    assertEquals(200,response.statusCode());

    JsonPath json = response.jsonPath();
    String username = json.getString("username");
    System.out.println("username" + username);

    assertEquals(200,response.statusCode());
    assertEquals(username,"FatimahAH");



}

}
