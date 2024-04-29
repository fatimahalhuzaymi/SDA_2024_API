package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class HW4 {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12
    Note: Print using JsonPath: response.jsonPath().prettyPrint();
*/
    @Test
    public void hw4() {


        String url = "https://automationexercise.com/api/productsList";
        Response response = given().when().get(url);

        JsonPath json = response.jsonPath();

        List<String> numWomen = json.getList("findAll{it.catagory.usertype == 'Women'}")

        System.out.println(numWomen);
        assertEquals(numWomen.size(),12);
    }
}
