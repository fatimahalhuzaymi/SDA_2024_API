package day05.HW;

import base_urls.hwd5url;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class DelRequest {
    public class DeleteRequest extends hwd5url {

        @Test
        public void test() throws JsonProcessingException {
            spec.pathParams("first", "user", "second", "FatimahAH");

            Response response = given(spec).when().contentType(ContentType.JSON).delete("{first}/{second}");

            JsonPath json = response.jsonPath();
            String username = json.getString("username");
            System.out.println("username" + username);

            assertEquals(200,response.statusCode());
            assertEquals(username,"FatimahAH");


        }
    }}
