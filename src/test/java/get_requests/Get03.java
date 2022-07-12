package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseUrl {

    /*
      Given
            https://jsonplaceholder.typicode.com/todos/23
      When
             User send GET Request to the URL
      Then
             HTTP Status Code should be 200
      And
             Response format should be "application/json"
      And
        "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
         "completed" is false
      And
         "userId" is 2
   */

    @Test
    public void get01(){
        //1. Step: Set the URL
       // String url="https://jsonplaceholder.typicode.com/todos/23"  // önerilmiyor.

        spec.pathParams("first","todos","second",23);

        //2. step set the expected data

        //3. step: Send the request and get the Response

       Response response = given().spec(spec).when().get("/{first}/{second}");

       //4. Do Assertion

        //1. yol
        response.then().assertThat().statusCode(200).contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

        //2. yol
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId",equalTo(2));

        /*

        Note 1 :Assertion yaparken Java çalısmayı durdugunda hata sonrası kodlar çalısmaz.
                Boylece hata sonrası assertion'lar hakkında bilgi sahibi olamayız.
                Fakat hata oncesi asserrtion'lar gecmıstır.

        Note 2: Eger kodumuzu hata noktasında duracak sekılde yazarsak "Hard Assertion" yapmış oluruz. (1. yol)
        Note 3: Eğer kodumuzu hata noktasında durmayacak sekılde yazarsak "soft Assertion" yapmış oluruz. (2. yol)
        Note 4: Eger çoklu body() methodu icinde assert yaparsak "Hard Assert" yapmış oluyoruz. (1. yol)
                tek body() methodu içinde asssert yaparsak "Soft Assert" yapmış oluyoruz. (2. yol)
         */




    }




}
