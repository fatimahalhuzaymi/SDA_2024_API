package day03;

import base_urls.RestFullBaseUrl;
import base_urls.petsurl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.path.json.JsonPath.given;
import static org.testng.AssertJUnit.assertEquals;

public class HW2 extends petsurl {

    /*
Write an automation test that will create a 'user'
using the "https://petstore.swagger.io/" document

*/

    @Test
    public void Hw2(){
        spec.pathParam("first","user");

         Map<String,Object> payloadu =new HashMap<>();

         payloadu.put("id",0);
         payloadu.put("username","hamad1990");
         payloadu.put("firstName","hamad");
         payloadu.put("lastName","hazani");
         payloadu.put("email","hamadhazani@gmail.com");
         payloadu.put("password","94763ed3");
         payloadu.put("phone","0554563586");
         payloadu.put("userStatus","0");

        System.out.println(payloadu);

        Response response = given(spec).body(payloadu).post("{first}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();
        assertEquals(200 , response.statusCode());

        Map<String,Object> actualData = response.as(Map.class);
        assertEquals(payloadu.put("id"),actualData.get("id"));
        assertEquals(payloadu.put("username"),actualData.get("username"));
        assertEquals(payloadu.put("firstName"),actualData.get("firstName"));




    }
}
