package API_Testing.RestAssuredAPITesting;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static io.restassured.RestAssured.*;

public class Parameterised {
  @Test(dataProvider = "dp")
  public void requestParameter(String n, String s) throws IOException {
	 /*
	  JSONObject json = new JSONObject();
	  json.put("name", s);
	  json.put("job", n); 
	  */
	  Path path = Paths.get("C:/Users/02155Y744/eclipse-workspace/RestAssuredAPITesting/target/classes/createdata.json");
	  System.out.println(path);
	  String strfrm = new String(Files.readAllBytes(path));
	  String newstr= strfrm.replace("Char1", s);
	  String newstra=newstr.replace("Char2", n);
	  System.out.println(newstra);
	  given().contentType("application/json").body(newstra).when()
	  .post("https://reqres.in/api/users")
	  .then()
	  .statusCode(201).log().body();
	  
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "leader", "vipin" },
      new Object[] { "leader", "morpheus" },
    };
  }
}
