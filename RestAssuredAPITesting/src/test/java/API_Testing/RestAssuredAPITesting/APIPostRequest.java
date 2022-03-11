package API_Testing.RestAssuredAPITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIPostRequest {
  @Test
  public void postRequest() {
	  
	  RestAssured.baseURI = "https://reqres.in/";
	  RequestSpecification request = RestAssured.given();

	  String requestbody = "{\n"
	  		+ "    \"email\": \"eve.holt@reqres.in\",\n"
	  		+ "    \"password\": \"pistol\"\n"
	  		+ "}";
	  
	  request.body(requestbody);
	  request.header("Content-Type","application/json");
	  Response response = request.request(Method.POST, "api/register");
	  System.out.println(response.asPrettyString());
  }
}
