package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_Login extends BaseClass {
	@Test
	public void verify_login()
	{
	 logger.info("*****starting tc002_logintest**********");
	 try 
	 {
	 // home page
	 HomePage hp=new HomePage(driver);
	 hp.clickMyAccount();
	 hp.clickLogin();
	 // login page 
	 LoginPage lp=new LoginPage(driver);
	 lp.enterEmail(p.getProperty("email"));
	 lp.enterPassword(p.getProperty("password"));
	 lp.clickLogin();
	 
	 
	 // myaccount page
	 
	 MyAccountPage macc=new MyAccountPage(driver);
	 boolean targetpage=macc.isMyAccountExists();
	 Assert.assertEquals(targetpage, true,"login failed");
	 //assert.asserttrue(targetpage);
	 }
	 catch(Exception e)
	 {
	Assert.fail();	 
	 }
	 
	 
	 logger.info("*****finished tc002_logintest");
	 
	}
	
	
	
	
}
