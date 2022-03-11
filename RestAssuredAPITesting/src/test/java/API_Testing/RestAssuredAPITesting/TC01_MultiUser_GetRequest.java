package API_Testing.RestAssuredAPITesting;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TC01_MultiUser_GetRequest {
	Response response;
	JsonPath jsn;
	Integer id;
	
	@BeforeTest
	public void sendrequest() {
		response = given().get("https://reqres.in/api/users?page=2");
		jsn= response.jsonPath();
	}
		
  @Test(priority= 1)
    public void multiuserGet() {
	 response.then().statusCode(200);
	Assert.assertTrue(response.getStatusLine().contains("OK"));
  }
 
  @Test(priority=2)
  	public void verfyresults(){
	 long times = response.getTime(); 
	 boolean reest = (times<5000);
	 Assert.assertTrue(reest);
	 response.then().assertThat().body(matchesJsonSchemaInClasspath("jsonschema.json")); 
  }
  
  @Test()
  public Integer recordcount() {
	  
	  List<String> allid = new ArrayList<>();
	  allid= jsn.getList("data.id");
	  System.out.println(allid+ " and "+ allid.size());
	  int sz = allid.size();
	  id = Integer.valueOf(allid.get(0));
	  Assert.assertTrue((sz==6));
	  return id;
  }
  
  @Test
  public void fieldsArePresent() {
	  int str =jsn.get("data[0].id");
	  Assert.assertFalse(str<=0);
	  String str1 = jsn.getString("data[0].id");
	  Assert.assertFalse(str1.isBlank());
	  for(int i=0; i<6; i++) {
	  response.then().rootPath("data[%d].id", withArgs(i)).body(withNoArgs(),notNullValue());
	  response.then().rootPath("data[%d].first_name", withArgs(i)).body(withNoArgs(),notNullValue());
	  }
  }
  
  @Test
  public void headercheck() {
	  response.then().header("content-type","application/json; charset=utf-8");
	   }
  
}
