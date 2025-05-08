package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j

public class BaseClassGrid2 {

	  public WebDriver driver;
	  public Logger logger;   // Log4j
	  public Properties p;  //  properties class
	  
	  
	  @BeforeClass(groups= {"sanity","Regression","Master"})
	  @Parameters({"os","browser"})
	  public void setup(String os,String br) throws InterruptedException, IOException	
	   
	  { 
		  	// loading config.properties file  
		  
		  FileReader file=new FileReader("./src//test//resources//config.properties");// path of config prop file is stored to file variable
		  p=new Properties(); // creating object of properties class
		  p.load(file);  // loading of properties from file
		  
		logger=LogManager.getLogger(this.getClass()); // accessing log.xml
		
		if (p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		   // os that is passed from xml file
		    
		    /*if (os == null) {
		        System.out.println("OS is not specified.");
		        return;
		    }
		 
		   if (os.equalsIgnoreCase("windows"))
		   {
			 capabilities.setPlatform(Platform.WIN11); 	
		   }
		   else if (os.equalsIgnoreCase("mac"))	 
		   {
			 capabilities.setPlatform(Platform.MAC);  
		   } 
		 
		 else
		 {
			 System.out.println("no machting os");
			 return;
		 } */
		    
		    if (os == null) {
		        System.out.println("OS is not specified.");
		        return;
		    }

		    switch (os.toLowerCase()) {
		        case "windows":
		            capabilities.setPlatform(Platform.WIN11); // Change to WIN11 if your Selenium version supports it
		            break;
		            
		        case "linux":
		            capabilities.setPlatform(Platform.LINUX); // Change to WIN11 if your Selenium version supports it
		            break;

		        case "mac":
		            capabilities.setPlatform(Platform.MAC);
		            break;

		        default:
		            System.out.println("No matching OS.");
		            return;
		    }
		 // browser   
		    
		 

		   
		   switch(br.toLowerCase())
		   {
		   
	
		    case "chrome":
		    	 ChromeOptions options = new ChromeOptions();
		    
		         options.addArguments("--headless=new");
		         options.addArguments("--no-sandbox");
		         options.addArguments("--disable-dev-shm-usage");
		         options.addArguments("--disable-gpu");
		         capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		         capabilities.setBrowserName("chrome");
		         break;
		    case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
		    case "firefox":capabilities.setBrowserName("firefox");break;
		    default: System.out.println("No matching browser");
		    return;
		   }
		   
		   driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities); // URL from standalone grid execution on cmd
		
     }
		
	if (p.getProperty("execution_env").equalsIgnoreCase("local"))
		
      {
		switch(br.toLowerCase())
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
		
	  }		
		  
		  
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//use localhost or the IP: this is the local ip of host window machine.using IP incase we want to run our testcase remotely using 
		//docker containers. since docker uses localhost there might be conflict when running the test cases
		
		driver.get("http://192.168.1.199/opencartsite/");
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
