package API_Testing.RestAssuredAPITesting;

//import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;
import static io.restassured.path.json.JsonPath.from;
import junit.framework.Assert;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;                   

public class GetAndPost {
  @Test
  public void GetRequest() {
	  baseURI ="https://reqres.in/api/";
	   given().get("users?page=2")
	  .then()
	  .assertThat()
	  .statusCode(200)
	  .body("page", is(2))
	  .body("data[1].id", equalTo(8))
	  .body("data.id",hasItems(7, 8,9,10,11,12));
	   
	   String response = get("users?page=2").asString();
	   List<String> names = from(response).getList("data.findAll {it.id>7}.first_name");
	   for(String i:names) {
		  System.out.println(i); 
	   }
	   
  }
  @Test
  public void filterresult() {
	  given().get("https://reqres.in/api/users?page=2").then().body("data.findAll{it.id>8}.first_name",hasItems("Tobias","Byron","George","Rachel"));
  }
  @Test
  public void randomitem() {
	  
	   given().get("https://reqres.in/api/users?page=2").then().body("data.first_name.collect{it.length()}.sum()", greaterThan(30));
  }
  
  @SuppressWarnings("unchecked")
@Test
  public void postrequest() {
	  JSONObject request = new JSONObject();
	  
	  request.put("name", "morpheus");
	  request.put("job", "leader");
	  
	  given().body(request.toJSONString()).when()
	  .post("https://reqres.in/api/users")
	  .then()
	  .assertThat()
	  .statusCode(201);
  }
  
  @Test
  public void requestpostfile() {
	  
	  given().body("postrequestpayload1.json").when()
	  .post("https://reqres.in/api/users")
	  .then()
	  .assertThat()
	  .statusCode(201);
	  }
  
  @SuppressWarnings("unchecked")
@Test
  public void putrequest() {
	  JSONObject object = new JSONObject();
	  baseURI= "https://reqres.in/";
	  object.put("name", "morpheus");
	  object.put("job", "zion resident");
	  
	  given().body(object.toJSONString())
	  .when()
	  .put("api/users/2")
	  .then()
	  .assertThat()
	  .statusCode(200);
  }
  @SuppressWarnings("unchecked")
@Test
  public void patchrequest() {
	  JSONObject object = new JSONObject();
	  baseURI= "https://reqres.in/";
	  object.put("name", "morpheus");
	  object.put("job", "zion resident");
	  
	  given().body(object.toJSONString())
	  .when()
	  .patch("https://reqres.in/api/users/2")
	  .then()
	  .assertThat()
	  .statusCode(200);
	  
	  String response  = given().body(object.toJSONString())
			               .when()
			                .patch("https://reqres.in/api/users/2").asString();
	 Assert.assertTrue(response.contains("updatedAt"));
  }
  @Test
  public void deleterequest() {
	  given().when().delete("https://reqres.in/api/users/2")
	  .then()
	  .assertThat()
	  .statusCode(204);
  }
}
