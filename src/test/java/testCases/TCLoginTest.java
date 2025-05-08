package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TCLoginTest extends BaseClassLogin {
	
	@Test
	public void verify_login(String email,String pwd,String exp)
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
	 lp.enterEmail(p.getProperty("email"));// or we can used passed in email and pwd
	 lp.enterPassword(p.getProperty("password"));//alternatively we can enter pwd
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
