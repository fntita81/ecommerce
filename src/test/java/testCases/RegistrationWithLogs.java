package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class RegistrationWithLogs extends BaseClass {
	
  
  @Test
  public void verify_account_registration() throws InterruptedException	
  {
	try {
		logger.info("********Starting Account Registration************"); 
		
		HomePage hp= new HomePage(driver) ;
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		logger.info("Providing customer details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.enterFirstName(randomString());
		regpage.enterLastName(randomString());
		regpage.enterEmail(randomString().toLowerCase()+"@gmail.com");//call was made to method for that randomly generated strings
		regpage.enterTelephone(randomNumber());
		
		String password =randomAlphaNumeric();
		
		regpage.enterPassword(password);
		regpage.confirmPassword(password);
		regpage.chkPolicy();
		regpage.clickContinue();
		
		Thread.sleep(5000);
		
		logger.info("Validating expected message....");
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Ha Been Created!"))
		{
	     Assert.assertTrue(true);
		}
		
		else
		{
		logger.error("Test failed.....");
		logger.debug("Debug logs...");
		Assert.assertTrue(false);
		}
		
	} 
	
	catch (Exception e) 
	{
		
		Assert.fail();
	}
	
	logger.info("****Finished Account Registration ******");
	
  }
  
  
  

  
  
}
