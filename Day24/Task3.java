package Testng_package;


/* 
 3. Write test cases for a dummy login page using @Parameters in testng.xml.
 */


import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task3 {
	  @Test
	  @Parameters({"username", "password"})
	  public void loginTest(@Optional("admin") String username,@Optional("admin123") String password) {
	      System.out.println("Username: " + username);
	      System.out.println("Password: " + password);
	      
	      if(username.equals("admin") && password.equals("admin123")) {
	    	  System.out.println("Login success");
	      } else {
	    	  System.out.println("Login failed");
	      }
	  }
	  
}
