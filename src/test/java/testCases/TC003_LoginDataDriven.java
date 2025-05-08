package testCases;
/*Data is valid - login success -test pass - logout
 * Data is valid- login failed-test fail
 * 
 * Data is invalid -- login success-test fail -logout
 * Data is invalid -- login failed -- test pass
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDriven extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)// provide class where dataProvider is found
	public void verify_loginDDT(String username,String password,String exp)
	{
		logger.info("*****Starting TC003_LogingDDT****");
		
		
		// home page
		try
		{
			
		 HomePage hp=new HomePage(driver);
		 hp.clickMyAccount();
		 hp.clickLogin();
		 
		 
		 // login page
     LoginPage lp=new LoginPage(driver);
	 lp.enterEmail(username);
	 lp.enterPassword(password);
	 lp.clickLogin();

	 // myaccount page
		 MyAccountPage macc=new MyAccountPage(driver);
		 boolean targetpage=macc.isMyAccountExists();
	 
		 /*Data is valid - login success -test pass - logout
		                   login failed-test fail
		  * 
		  * Data is invalid -- login success-test fail -logout
		  *                 -- login failed -- test pass
		  */
		 
		if(exp.equalsIgnoreCase("Valid")) 
		{
			if(targetpage==true)
			{
		        logger.info("Login passed for valid credentials");
				macc.clickLogout();
			Assert.assertTrue(targetpage, "Login passed for valid credentials");
			    logger.info("Login passed for valid credentials");
				//Assert.assertTrue(true);	
			}	
			else
			{
				 Assert.assertFalse(targetpage, "Login failed for valid credentials");
				 logger.info("Login failed for valid credentials");
				//Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
			
		    {
			   if(targetpage==true)
			  {
				logger.error("Login succeeded for invalid credentials");   
				macc.clickLogout();
				Assert.assertFalse(targetpage, "Login succeeded with invalid credentials");
				//Assert.assertTrue(false);	
			  }
			   
			   else
			   {
				 logger.info("Login failed for invalid credentials as expected");
				 
				  Assert.assertTrue(true)  ;
				   
			   }
			   
		    }
		   
	         }
	          catch(Exception e)
	         {
	         	Assert.fail();
	         }
	         
	
		logger.info("*****Fininsh TC003_LogingDDT****");
	}
	
}


	



