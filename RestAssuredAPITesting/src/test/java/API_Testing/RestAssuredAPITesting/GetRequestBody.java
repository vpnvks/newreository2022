package API_Testing.RestAssuredAPITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import static org.hamcrest.Matchers.*;

public class GetRequestBody {
  @Test
  public void getrequest() throws IOException {
	  baseURI="https://reqres.in";
	  Response responses=get("/api/users/2");
	  String lastname = responses.path("data.last_name");
	  String headerd = responses.header("Content-Type");
	  //System.out.println(responses.headers().toString());
	  System.out.println(lastname);
	  System.out.println(headerd);
	  //or direclty frm request
	 String str= get("/api/users/2").then().body("data.first_name",equalTo("Janet")).extract().path("data.first_name");	  
	 System.out.println("extracted value is "+str);
  }
  
  @Test
  public void loginrequest1() {
	  //JSONObject jsonbody = new JSONObject();
	 // jsonbody.put( "email", "eve.holt@reqres.in");
	  //jsonbody.put( "password", "cityslicka");
	  
	 /* given().body(jsonbody.toJSONString()).
	  when().get("https://reqres.in/api/login")
	  .then().statusCode(200)
	  .log().all(); 
	  given().auth().basic("eve.holt@reqres.in", "cityslicka").
	  when().get("https://reqres.in/api/login")
	  .then().statusCode(200)
	  .log().all();*/
	  RestAssured.authentication = basic("eve.holt@reqres.in", "cityslicka");	  
	  when().get("https://reqres.in/api/login").then().statusCode(200).log().all();
	  
  }
}
