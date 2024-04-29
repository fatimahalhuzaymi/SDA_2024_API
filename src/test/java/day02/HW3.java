package day02;

import base_urls.RestFullBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.path.json.JsonPath.given;
import static org.testng.Assert.assertEquals;

public class HW3 extends RestFullBaseUrl {
     /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then
            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void hw3(){
        String url="https://reqres.in/api/unknown/";

        Response response  = given(url).get();
        response.prettyPrint();

        response.then().statusCode(200);

        JsonPath json = response.jsonPath();

        List<String> pantoneValues = json.getList("data.pantone_value");
        System.out.println("pantone_values"+pantoneValues);

        List<String> id = json.getList("findall {it.id>3}.id");
        System.out.println("id"+id);

        assertEquals(3,id.size());

        List<String> names = json.getList("data.find all {it.id<3}.name");
        System.out.println("names"+names);

        assertEquals(2,names.size());



    }
}
