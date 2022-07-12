import io.restassured.response.Response;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get01() {
        //1. set the Url
        String url="https://restful-booker.herokuapp.com/booking/55";
        //2. set the expected data(Post - Put - Patch)

        //3. Type code To send request
        Response response = given().when().get(url);
        response.prettyPrint();

        //4.Do Assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //Response body'de bulunan spesifik bir veri nasıl asssert edilir.
        //assertTrue() methodu parantezin içindeki değer true ise testi geçirir.
        assertTrue(response.asString().contains("Not Found"));  // asString() methodunu kullanmalıyız

        //Response body'de  spesifik bir verinin bulunmadigini nasıl asssert edilir.
        //assertFalse() methodu parantezin içindeki değer false ise testi geçirir.
        assertFalse(response.asString().contains("TechProEd"));

        //assertEquals() methodu içindeki iki değer eşit ise testi gecirir.
        assertEquals("Cowboy",response.header("Server"));
        assertTrue(response.header("Server").equals("Cowboy"));  //böyle de olur.


    }
}
