package API_Testing.RestAssuredAPITesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC02_SingleUser_GetRequestTest {
Integer id;
Response response, responsen;
JsonPath Jpathn;

	@BeforeTest
	public void sendrequest() {
		response = given().get("https://reqres.in/api/users?page=2");
		JsonPath jpath = response.jsonPath();
		int id = jpath.getInt("data[0].id");
		System.out.println("id value is "+id);
		String url = "https://reqres.in/api/users/"+id;
		System.out.println("final url is "+url);
		responsen  = given().get(url);
		Jpathn = responsen.jsonPath();
	}
	
	@Test
	public void verfyresultsTest() {
		responsen.then().log().body();
		responsen.then().statusCode(200);
		Jpathn.get("data.first_name").equals("Michael");
	}
}
