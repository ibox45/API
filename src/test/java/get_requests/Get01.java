package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
    1)Postman manuel API testi icin kullanılır.
    2)API otomasyon testi icin Rest-Assured Library kullanıyoruz
    3)Otomasyon kodlarının yazımı icin şu adımları izliyoruz
        a)Gereksinimleri anlama
        b)Test case 'i yazma
            i)Test case yazımı icin 'Gherkin Language' kullanıyoruz.
                'Gherkin' bazı keywordlere sahip, bunlar;
                x)Given: Ön Koşullar
                y)When : Aksiyonlar --> Get, Put, ...
                z)Then: Dönütler(Output)-->Doğrulama, response, ...
                t)And: Coklu işlemler icin kullanılır.

        c)Testing kodunun yazımı

            i)Set the URL
            ii)Set the expected data(POT-PUT-PATCH)
            iii)Type code to send request
            iv)Do Assertion

     */

    /*
    Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */



    @Test
    public void get01(){
      //  i)Set the URL
        String url="https://restful-booker.herokuapp.com/booking/1642";
      //  ii)Set the expected data(POST-PUT-PATCH)

      //  iii)Type code to send request
       Response response= given().when().get(url);
       response.prettyPrint();

       //  iv)Do Assertion
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //'Status Code' nasıl yazdırılır
        System.out.println("Status Code: "+response.statusCode());
        //'Content Type' nasıl yazdırılır
        System.out.println("Content Type: "+response.contentType());
        //'Status Line' nasıl yazdırılır
        System.out.println("Status Line :"+response.statusLine());

        //'Header' nasıl yazdırılır
        System.out.println(response.header("Connection"));  //keep-alive
        //'Headers' nasıl yazdırılır
        System.out.println("Headers:\n"+response.headers());
        //'Time' nasıl yazdırılır
        System.out.println("Time :"+response.getTime());





    }



}
