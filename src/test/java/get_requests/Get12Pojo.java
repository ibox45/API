package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get12Pojo extends HerOkuAppBaseUrl {
    /*
    Given
            https://restful-booker.herokuapp.com/booking/5
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
                                    "firstname": "Mark",
                                    "lastname": "Brown",
                                    "totalprice": 896,
                                    "depositpaid": true,
                                    "bookingdates": {
                                        "checkin": "2015-12-29",
                                        "checkout": "2019-03-22"
                                    },
                                    "additionalneeds": "Breakfast"
                                 }
     */

    @Test
    public void getPojo01(){
        //1. Step: Set the Url
        spec.pathParams("first","booking","second",5);

        //2. Step: Set the expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2015-12-29","2019-03-22");
        BookingPojo bookingPojo =new BookingPojo("Mark","Brown",896,true,bookingDatesPojo,"Breakfast");

        //3. Step: Send the get request get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4. Step: Do Assertion
        BookingPojo actualPojo=response.as(BookingPojo.class);
        assertEquals(200,response.getStatusCode());

        assertEquals(bookingPojo.getFirstname(),actualPojo.getFirstname());
        assertEquals(bookingPojo.getLastname(),actualPojo.getLastname());
        assertEquals(bookingPojo.getTotalprice(),actualPojo.getTotalprice());
        assertEquals(bookingPojo.getDepositpaid(),actualPojo.getDepositpaid());
        assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualPojo.getBookingdates().getCheckout());
        assertEquals(bookingPojo.getAdditionalneeds(),actualPojo.getAdditionalneeds());



    }







}
