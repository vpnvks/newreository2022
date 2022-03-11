package API_Testing.RestAssuredAPITesting;

import java.io.*;
import java.util.Scanner;

import org.testng.annotations.Test;

public class FileReader {
  @Test
  public void f() throws FileNotFoundException {
	  File file = new File("C:\\Users\\02155Y744\\eclipse-workspace\\RestAssuredAPITesting\\pathfile.txt");
	  //BufferedReader bfrrd = new BufferedReader(new FileReader());
	  //FileReader fl = new FileReader("C:\\Users\\02155Y744\\eclipse-workspace\\RestAssuredAPITesting\\target\\classes\\createdata.json");
	  file.setWritable(true);
	 //System.out.println(file.isDirectory());
	 //File[] fl = file.listFiles();
	// for(int i=0; i<fl.length;i++) {
		// System.out.println(fl[i]);
	 //}
	 // System.out.println(new  File(".").getAbsoluteFile());
	  System.out.println(file.exists());
	  System.out.println(file.canRead());
	  if(file.exists()) {
	  @SuppressWarnings("resource")
	Scanner sc = new Scanner(file);
	  while(sc.hasNextLine()) {
		  System.out.println(sc.nextLine());
	  }
	  }
  }
}
	