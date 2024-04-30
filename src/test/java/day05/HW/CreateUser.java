package day05.HW;

import base_urls.hwd5url;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utlities.ObjectMapperUtilities.convertJsonToJava;

public class CreateUser extends hwd5url {

    @Test
public void test(){
        spec.pathParam("firsr","user");
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

        assertEquals(200,response.statusCode());


    }


}
