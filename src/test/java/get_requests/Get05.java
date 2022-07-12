package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Niklas" and last name is "Stadler"
     */

    @Test
    public void get01(){

        //1. Step: Set the Url

        //https://restful-booker.herokuapp.com/booking?firstname=Niklas&lastname=Stadler
        spec.pathParam("first","booking").
                queryParams("firstname","Niklas","lastname","Stadler");

        //2. Step: set the expected data

        //3. Step: Send the request get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();


        //4. Step: Do Assertion
        response.then().assertThat().statusCode(200);

        assertTrue(response.asString().contains("bookingid"));


    }



}
