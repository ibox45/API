package delete_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Delete01 extends JsonPlaceHolderBaseUrl {

    /*
    Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01(){
        //1. Step: Set the url
        spec.pathParams("first","todos","second",198);

        //2. Step: Set the expected Data
        Map<String , Object> expectedDataMap = new HashMap<>();

        //3. Step: Send DELETE Request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //4. Step:  Do Assertion
        Map<String, Object> actualMap = response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        assertEquals(expectedDataMap,actualMap);

        //2. yol
        assertTrue(actualMap.size()==0);   //1.
        assertEquals(0, actualMap.size());  //2.
        assertTrue(actualMap.isEmpty());  //3. Tavsiye edilen

        //Delete request yapmadan once "Post Request" yapıp o datayı silmeliyiz.
        







    }


}
