package API_Testing.RestAssuredAPITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIParameterPass {
  @SuppressWarnings("unchecked")
  @Test
  public void Parameterpassing() {
	  
	  RestAssured.baseURI = "https://reqres.in/";
	  RequestSpecification request = RestAssured.given();
	  JSONObject json = new JSONObject();
	  
	  json.put("name", "morpheus");
	  json.put("job", "zion resident");
	  
	  request.header("content-type","Application/json");
	  request.body(json);
	  
	  Response response = request.request(Method.PUT,"api/users/2");
	  System.out.println(response.asPrettyString());
	  
  }
  
  @Test
  public void logging() {
	 // RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	  given().log().ifValidationFails().
	  get("https://reqres.in/api/users/2")
	  .then().statusCode(200);
	  
	  get("https://reqres.inapi/user/").then().log().ifError();
	  
	  when().get("https://reqres.in/api/users/2").then()
	  .statusCode(200).log().ifStatusCodeIsEqualTo(201);
	 
	  
  }
  
  @Test
  public void loging2() {
	  
	  given().get("https://reqres.in/api/users/2").then()
	  .log().ifValidationFails().statusCode(201);
	 
  }
  @Test
  public void root() {
	 when().get("https://reqres.in/api/users?page=2").then().rootPath("data.%s[%d]").body(withArgs("id",0), equalTo(7));
		 
  }
  @Test
  public void sessionid() {
	  String sen = get("https://reqres.in/api/users?page=2").sessionId();
	  System.out.println(sen);
  }
}
