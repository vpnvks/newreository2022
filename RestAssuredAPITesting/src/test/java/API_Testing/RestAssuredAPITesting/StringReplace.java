package API_Testing.RestAssuredAPITesting;

import org.testng.annotations.Test;

public class StringReplace {
  @Test
  public void f() {
	  String s="india";
	  String str = "{\"hello this is vipin:\""+ s+" \"I am here to resolve issue\"}";
	  System.out.println(str);
	  String result=str.replace("here", "there");
	  
	  System.out.println(result);
  }
}
