package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	
	public boolean isMyAccountExists()
	{
	  try
	  {
		return(msgHeading.isDisplayed());
	  } 
	  catch (Exception e)
	  {
		
		e.printStackTrace();
		return false;
	  }	
	  
	}

	public void clickLogout() {
		lnkLogout.click();
		
	}
	
}
