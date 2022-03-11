package API_Testing.RestAssuredAPITesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TC03_SingleUser_NotFound {
	Response response;
  @Test
  public void getUser() {
	  response.then().statusCode(404);
	  response.statusLine().contains("Not Found");
  }
  @Test
  public void headerverification() {
	  response.then().assertThat().header("content-type","application/json; charset=utf-8")
	  .and().header("x-powered-by", "Express");
	  String str = response.header("date");
	  boolean strresp = str.contains("GMT");
	  Assert.assertTrue(strresp);
  }
  
    
  @BeforeTest
  public void beforeTest() {
	  response = given().get("https://reqres.in/api/users/23");
  }

}
