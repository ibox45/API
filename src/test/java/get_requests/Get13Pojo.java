package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestResponseBody;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get13Pojo extends GoRestBaseUrl {
    /*
    Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
                {
             "meta": null,
             "data": {
                     "id": 2508,
                     "name": "Sanka Pillai",
                     "email": "sanka_pillai@pacocha.org",
                     "gender": "male",
                     "status": "inactive"
                 }
          }

     */

    @Test
    public void getPojo01(){
        //1. Step: Set the Url
        spec.pathParams("first","users","second" ,2508);

        //2. Step: Set the expected data
        GoRestDataPojo goRestDataPojo =new GoRestDataPojo(2508,"Sanka Pillai","sanka_pillai@pacocha.org","male","inactive");
        GoRestResponseBody goRestResponseBody =new GoRestResponseBody(null,goRestDataPojo);

        //3. Step: Send the get request get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4. Step: Do Assertion
        GoRestResponseBody actualPojo = response.as(GoRestResponseBody.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(goRestResponseBody.getMeta(),actualPojo.getMeta());
        assertEquals((goRestResponseBody.getData().getId()),actualPojo.getData().getId());
        assertEquals((goRestResponseBody.getData().getName()),actualPojo.getData().getName());
        assertEquals((goRestResponseBody.getData().getEmail()),actualPojo.getData().getEmail());
        assertEquals((goRestResponseBody.getData().getGender()),actualPojo.getData().getGender());
        assertEquals((goRestResponseBody.getData().getStatus()),actualPojo.getData().getStatus());



    }


}
