package API_Testing.RestAssuredAPITesting;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.RestAssured;

public class APISchemaValidation {
  @Test
  public void getSchema() {
	  RestAssured.given()
	  .get("https://reqres.in/api/users/2")
	  .then()
	  .assertThat()
	  .body(matchesJsonSchemaInClasspath("schema.json"));
  }
}
