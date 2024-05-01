package HW06;

import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.BookingPojo;
import pojo.BookingResponsePojo;
import testdata.RestfulTestData;
import utlities.ObjectMapperUtilities;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class HWd6 extends RestFullBaseUrl {

    @Test
    public void CreateBooking() {
        spec.pathParam("first", "booking");

        String expectedStr = """
                             
                                           
                                             {
                                                "firstname" : "lora",
                                                "lastname" : "namar",
                                                "totalprice" : 900000,
                                                "depositpaid" : true,
                                                "bookingdates" : {
                                                    "checkin" : "2018-01-01",
                                                    "checkout" : "2019-01-01"
                                                },
                                                "additionalneeds" : "Breakfast"
                                         
                               
                }""";

        BookingPojo payLoad = ObjectMapperUtilities.convertJsonToJava(expectedStr, BookingPojo.class);

        Response response = given().body(payLoad).when().post("first");
        response.prettyPrint();

        BookingResponsePojo actualData = ObjectMapperUtilities.convertJsonToJava(response.asString(), BookingResponsePojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(payLoad.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(payLoad.getLastname(), actualData.getBooking().getLastname());
        assertEquals(payLoad.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(payLoad.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(payLoad.getBookingdates(), actualData.getBooking().getBookingdates());
        assertEquals(payLoad.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());
    }
        @Test
                public void getBooking(){

        spec.pathParams("first","booking","second","1020");

            String expectedStr = """
                             
                                           
                                             {
                                                "firstname" : "lora",
                                                "lastname" : "namar",
                                                "totalprice" : 900000,
                                                "depositpaid" : true,
                                                "bookingdates" : {
                                                    "checkin" : "2018-01-01",
                                                    "checkout" : "2019-01-01"
                                                },
                                                "additionalneeds" : "Breakfast"
                                         
                               
                }""";
            BookingPojo expectedData = ObjectMapperUtilities.convertJsonToJava(expectedStr, BookingPojo.class);

            Response response = given(spec).when().get("firist","second");
            BookingResponsePojo actualData = ObjectMapperUtilities.convertJsonToJava(response.asString(), BookingResponsePojo.class);

            assertEquals(200, response.statusCode());
            assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
            assertEquals(expectedData.getLastname(), actualData.getBooking().getLastname());
            assertEquals(expectedData.getTotalprice(), actualData.getBooking().getTotalprice());
            assertEquals(expectedData.getDepositpaid(), actualData.getBooking().getDepositpaid());
            assertEquals(expectedData.getBookingdates(), actualData.getBooking().getBookingdates());
            assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());




        }
    }