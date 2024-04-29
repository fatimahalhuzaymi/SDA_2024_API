package day03;

import base_urls.JsonPlaceHolderBaseUrl;
import base_urls.hw1d3url;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class HW1 extends hw1d3url {
     /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */
    @Test
    public void hw3(){
        spec.pathParam("first","users");

        Map<String, Object> payLoad = new HashMap<>();

        payLoad.put("name","morpheus");
        payLoad.put("job","leader");

        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPath json = response.jsonPath();
        assertEquals(201,response.statusCode());
        assertEquals(payLoad.get("id"),json.getInt("id"));

        Map<String,Object> actualData = response.as(Map.class);
        assertEquals(201,response.statusCode());
        assertEquals(payLoad.get("id"),actualData.get("id"));
        assertEquals(payLoad.get("name"),actualData.get("name"));
        assertEquals(payLoad.get("job"),actualData.get("leader"));

    }
}
