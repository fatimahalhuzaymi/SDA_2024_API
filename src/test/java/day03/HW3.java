package day03;

import base_urls.petsurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.path.json.JsonPath.given;
import static org.testng.Assert.assertTrue;

public class HW3 extends petsurl {
   // Using the https://petstore.swagger.io/ document,
    // write an automation test that finds the number of "pets"
    // with the status "available" and asserts that there are more than 100.

@Test
    public void Hw3(){
    spec.pathParams("1","pet", "2","status");


    Response response = given(spec)
            .queryParam("status", "available").get("{1}/{2}");


    int npet =response.jsonPath().getList("").size();
    System.out.println(npet);
    assertTrue(npet>100,"available pet")
}











}
