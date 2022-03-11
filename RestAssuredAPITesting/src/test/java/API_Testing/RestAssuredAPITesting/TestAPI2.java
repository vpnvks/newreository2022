package API_Testing.RestAssuredAPITesting;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAPI2 {
  @Test
  public void listUser() {
	  
	  RestAssured.baseURI = "https://reqres.in/";
	  PreemptiveBasicAuthScheme preauth = new PreemptiveBasicAuthScheme();
	  preauth.setUserName("vm4254");
	  preauth.setPassword("anshgdu");
	  
	  RequestSpecification request = RestAssured.given();
	  Response response = request.request(Method.GET,"api/users?page=2");
	  
	  response.prettyPrint();
	  JsonPath jsonpresp= response.jsonPath();
	  //System.out.println(jsonpresp.getString("data[0].first_name"));
	  System.out.println(jsonpresp.get("data[0].first_name"));
	  System.out.println(jsonpresp.get("data[1].first_name"));
	  System.out.println(jsonpresp.get("data[2].last_name"));
	  System.out.println(response.getStatusLine());	
	  JsonPath jsonresp=response.getBody().jsonPath();
	  System.out.println(jsonresp);
	  //System.out.println(response.body().peek());
	  //response.p
	  Headers header =response.headers();
	  System.out.println(header.getValue("Content-Type"));
	  System.out.println(header.get("Content-Type"));
	  System.out.println((header.get("Content-Type")).toString().equals("Content-Type=application/json; charset=utf-8"));
  }
}
