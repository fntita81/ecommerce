package testCases;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j

public class BaseClassWithParameterization {

	  public WebDriver driver;
	  public Logger logger;   // Log4j
	  
	  @BeforeClass
	  @Parameters({"os","browser"})
	  public void setup(String os,String br) throws InterruptedException	
	  {
		 logger=LogManager.getLogger(this.getClass()); 
	
		 switch (br.toLowerCase())
		 {
		 case "chrome":
		       driver=new ChromeDriver(); 
		       break;
		 
		 case"edge":
			 driver=new EdgeDriver(); 
			 break;
			 
		 case"firefox":
			 driver=new FirefoxDriver(); 
			 break;
		default:System.out.println("Invalid browser name");	
		return;
			 
		 }
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/OpencartSite/");
		driver.manage().window().maximize();
		
	    Thread.sleep(5000);
	  }
	  

	  // user define method to randomly generate string
	   //RandomStringUtils is not a java class but from appache lang3 commons
	   
	   public String randomString()
	   {
	 	String ran=RandomStringUtils.randomAlphabetic(8);// generated random string
	 	String ran2=ran.toLowerCase();// string changed to lower case and store in ran2
	 	String generated=ran2.substring(0,1).toUpperCase()+ran2.substring(1);  
	 	return generated;
	   }
	   
	   // generating randowm numbers
	   
	   public String randomNumber()
	   {
	 	String prefix = "07450"; // Fixed prefix 
	     String randomNumber=prefix+RandomStringUtils.randomNumeric(5);// generated random string
	 	return randomNumber;
	   }
	   
	   public String randomAlphaNumeric()
	   {
	 	String alpha=RandomStringUtils.randomAlphabetic(5);
	     String alphaNumeric=RandomStringUtils.randomNumeric(3);
	     
	 	return (alpha+"@"+alphaNumeric);
	   }
	   
	  @AfterClass
	  public void tearDown()	
	  {
		  driver.quit();  
	  }
	  
	  
	  
}
