package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
  
  @Test
  public void verify_account_registration() throws InterruptedException	
  {
	HomePage hp= new HomePage(driver) ;
	hp.clickMyAccount();
	hp.clickRegister();
	
	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	regpage.enterFirstName(randomString());
	regpage.enterLastName(randomString());
	regpage.enterEmail(randomString().toLowerCase()+"@gmail.com");//call was made to method for that randomly generated strings
	//regpage.enterTelephone(randomNumber());
	
	String password ="password123";//randomAlphaNumeric();
	
	regpage.enterPassword(password);
	//regpage.confirmPassword(password);
	Thread.sleep(5000);
	regpage.chkPolicy();
	Thread.sleep(5000);
	regpage.clickContinue();
	
	Thread.sleep(5000);
	
	String confmsg=regpage.getConfirmationMsg();
	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	System.out.println(confmsg);
  }
  
 

  
  
  
  
  
}
