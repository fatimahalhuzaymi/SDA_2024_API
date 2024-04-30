package day05.HW;

import base_urls.hwd5url;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utlities.ObjectMapperUtilities;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static utlities.ObjectMapperUtilities.convertJsonToJava;

public class ReadRequest extends hwd5url {


    @Test
    public void read(){
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
        Response response = given(spec).when().contentType(ContentType.JSON).get("{first}/{second}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();
        String username = json.getString("username");
        System.out.println("username" + username);

        Assert.assertTrue(username.contains("FatimahAH"));


    }
}
