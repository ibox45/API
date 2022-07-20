package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {
    /*
    Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Jyotsana Guneta", "Harinarayan Embranthiri", "Anurag Kaur" are among the users
        And
            The female users are more than or equals to  male users
     */

    @Test
    public void get01(){
        //1. Step: Set the Url
        spec.pathParam("first","users");

        //2. Step: Set the Expected Data --map ile ugrasmamak icin yapmıyoruz bu soruda

        //3. Step: Send the Request get the Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4. Step: Do Assertion

       // body() methodu ile

        response.
                then().
                assertThat().
                statusCode(200).
                body("meta.pagination.limit",equalTo(10),
                        "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data.id",hasSize(10),
                        "data.status",hasItem("active"),
                        "data.name",hasItems("Jyotsana Guneta", "Harinarayan Embranthiri", "Anurag Kaur"));

        //Bayan ve erkek sayısını karsılastıralım
        //1. yol: Tüm cinsiyetleri çekip bayan sayısı ıle karsılastıralım

        JsonPath json = response.jsonPath();
        List<String> genders =json.getList("data.gender");
        int numOfFemales=0;
        for(String w: genders){
            if(w.equalsIgnoreCase("female")){
                numOfFemales++;
            }
        }
        assertTrue(numOfFemales >= genders.size()-numOfFemales);

        //2. yol : Tüm bayan ve bayları ayrı ayrı Groovy ile cekelim
        List<String> femaleList=json.getList("data.findAll{it.gender=='female'}.gender");
        List<String> maleList=json.getList("data.findAll{it.gender=='male'}.gender");
        assertTrue(femaleList.size()>maleList.size());



    }

}
