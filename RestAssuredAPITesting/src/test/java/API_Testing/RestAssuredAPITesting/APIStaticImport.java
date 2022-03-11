package API_Testing.RestAssuredAPITesting;

import org.testng.annotations.Test;

//import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;


public class APIStaticImport {
  @Test(priority=1)
  public void staticimport() {
	  given().when().get("https://reqres.in/api/users/2").then().log().all();
}
  
  @Test(priority=2)
  public void param() {
	  given().queryParam("name","vipin").queryParam("job","resident").
	  when().put("https://reqres.in/api/users/2").then().log().all();
  }
  @Test(priority=3)
  public void statuscode() {
	  String url = "https://reqres.in/api/users/2";
	  
	  given().queryParam("name","morpheus").queryParam("job","zion resident").when().
	  patch(url).then().assertThat().statusCode(200);
	  }
  @Test(priority=4)
  public void header() {
	  String url = "https://reqres.in/api/unknown/2";
	  System.out.println("below we are printing headers detail");
	  System.out.println(get(url).then().extract().headers());
  }
  @Test
  public void accessingelement() {
	  String url = "https://reqres.in/api/users?page=2";
	  Response response = get(url);
	  JsonPath jsonp =response.jsonPath();
	  
	  //Headers header = response.getHeaders();
	  ArrayList<String> id1 = jsonp.get("data.id");
	  ArrayList<String> name = jsonp.get("data.first_name");
	  List<Object> namel = jsonp.getList("data.last_name");
	 System.out.println(id1);
	 System.out.println(name);
	 System.out.println(namel.size());
	 System.out.println(namel);
	List<JsonPath> id12 = jsonp.get("data.findAll { data -> data.id >= 8 && data.id <= 11 }");
	System.out.println((id12));		 
  }
}
