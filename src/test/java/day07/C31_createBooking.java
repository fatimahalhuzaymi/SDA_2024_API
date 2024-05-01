package day07;
import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.BookingPojo;
import pojo.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utlities.ObjectMapperUtilities.convertJsonToJava;

public class C31_createBooking extends RestFullBaseUrl {

    /*
    Given
        url: "https://restful-booker.herokuapp.com/booking
    And
        body:     {
                    "firstname" : "Jim",
                    "lastname" : "Brown",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2018-01-01",
                        "checkout" : "2019-01-01"
                    },
                    "additionalneeds" : "Breakfast"
                }

    When
        user send post request
    Then
        verify status code is 200
    And
        response is like :
        {
    "bookingid": 1,
    "booking": {
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
}

     */

    static int bookingid;

    static BookingPojo payload;
    @Test
    public void test() {

        //set url
        spec.pathParam("1", "booking");

        // set expected data
        String payloadStr = """
                {
                                    "firstname" : "Jim",
                                    "lastname" : "Brown",
                                    "totalprice" : 111,
                                    "depositpaid" : true,
                                    "bookingdates" : {
                                        "checkin" : "2018-01-01",
                                        "checkout" : "2019-01-01"
                                    },
                                    "additionalneeds" : "Breakfast"
                                }""";

        payload = convertJsonToJava(payloadStr, BookingPojo.class);

        //send req and send res

        Response response = given(spec).body(payload).post("{1}");
        response.prettyPrint();


        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(payload.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(payload.getLastname(), actualData.getBooking().getLastname());
        assertEquals(payload.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(payload.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(payload.getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(payload.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(payload.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());

        int bookingid = response.jsonPath().getInt("bookingid");
        System.out.println("bookingid = " + bookingid);
    }
}

