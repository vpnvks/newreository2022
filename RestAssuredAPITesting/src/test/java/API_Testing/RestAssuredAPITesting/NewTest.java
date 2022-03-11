package API_Testing.RestAssuredAPITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class NewTest {
	String Baseuri = "https://reqres.in/";
  @Test
  public void getrequest() {
	  
	  
	  RestAssured.baseURI = Baseuri;
	  RequestSpecification httprequest = RestAssured.given();
	  
	  Response response = httprequest.request(Method.GET,"api/users/2");
	  
	  String string = response.getBody().asString();
	  
	  System.out.println(string);
	  
	  int statuscode = response.getStatusCode();
	  System.out.println(statuscode);
	  Assert.assertEquals(statuscode, 200);
	  //String resmsg = response.getStatusLine();
	  //System.out.println("status line message is "+resmsg);
	  //System.out.println("pretty print version is "+response.prettyPrint());
	  Headers header = response.getHeaders();
	  System.out.println(response.asPrettyString());
	  	  long time = response.getTime();
	  System.out.println("total time taken is = "+time);
	  if(time<2000) {
		  Assert.assertTrue(true);
	  }
	  
	  for(Header i:header) {
		  System.out.println(i.getName()+"----> "+i.getValue());
	  }
	  
	  Assert.assertTrue(string.contains("last_name"));
	  JsonPath jsonpath = response.jsonPath();
	  System.out.println("id " + jsonpath.get("data.id"));
	  System.out.println("email " + jsonpath.get("data.email"));
	  System.out.println("first name"+ jsonpath.get("data.first_name"));
  }
  
  @Test
  public void usernotfound() {
	  RestAssured.baseURI = Baseuri;
	  RequestSpecification httprequest = RestAssured.given();
	  
	  Response response = httprequest.request(Method.GET,"api/users/23");
	  
	  String resstr = response.getBody().toString();
	  System.out.println("direct response is "+response);
	  System.out.println("response after string conversion is "+resstr);
	  int rescode = response.getStatusCode();
	  Assert.assertEquals(rescode, 404);
	  String resmsg = response.getStatusLine();
	  System.out.println(resmsg);
  }
  
}
