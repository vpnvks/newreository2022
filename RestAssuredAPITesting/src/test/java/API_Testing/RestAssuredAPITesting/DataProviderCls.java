package API_Testing.RestAssuredAPITesting;

import org.testng.annotations.Test;

public class DataProviderCls {
  @Test
  public void f() {
	  DataProviderCls cls = new DataProviderCls();
	  Object[][] obj = (cls.data("vipin", 30));
	  System.out.println(obj[0][0]+" and "+obj[0][1] );
	  System.out.println(obj[1][0]+" and "+obj[1][1] );
  }
  
  public Object[][] data(String a, int b) {
	
	  return new Object[][]{
	   new Object[] {b, a},
	   new Object[] {(b+1), a+"s"}
	  };
	  
  }
}
