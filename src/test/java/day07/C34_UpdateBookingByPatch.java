package day07;
import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.Map;
import static day07.C31_createBooking.bookingid;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utlities.ObjectMapperUtilities.convertJsonToJava;

public class C34_UpdateBookingByPatch extends RestFullBaseUrl {
    /*
Given
url: "https://restful-booker.herokuapp.com/booking/:id
And
body:     {
            "firstname" : "Tom",
            "lastname" : "Hanks",
        }

When
user send patch request
Then
verify status code is 200
And
response is like :
                    {
                "firstname" : "Tom",
                "lastname" : "Hanks",
                "totalprice" : 111,
                "depositpaid" : true,
                "bookingdates" : {
                    "checkin" : "2018-01-01",
                    "checkout" : "2019-01-01"
                },
                "additionalneeds" : "Lunch"
            }
*/
    @Test(dependsOnMethods = {"day07.C31_CreateBooking.createBookingTest"})
    public void UpdateByPatchTest() {
        // Set Url
        spec.pathParams("first", "booking", "second", bookingid);

        // Set Expected Data

        String payloadStr = """
                {
                                        "firstname" : "Tom",
                                        "lastname" : "Hanks"
                                    }""";

        Map<String, Object> payload = convertJsonToJava(payloadStr, Map.class);

        // Send Request And Get Response
        Response response = given(spec).body(payload).when().patch("{first}/{second}");
        response.prettyPrint();

        // Do Assertions
        Map<String, Object> actualData = convertJsonToJava(response.asString(), Map.class);
        assertEquals(200, response.statusCode());
        assertEquals(payload.get("firstname"), actualData.get("firstname"));
        assertEquals(payload.get("lastname"), actualData.get("lastname"));
    }
}