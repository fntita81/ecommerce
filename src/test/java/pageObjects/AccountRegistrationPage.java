package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 public class AccountRegistrationPage extends BasePage
 {
	
	public AccountRegistrationPage(WebDriver driver)
	{
      super(driver);
		
	}
	
  @FindBy( xpath="//input[@id='input-firstname']")
  WebElement txtFirstname;
  
  @FindBy(xpath="//input[@id='input-lastname']")
  WebElement txtLastname;
  
  @FindBy(xpath="//input[@id='input-email']")
  WebElement txtEmail;
  
  @FindBy(xpath="//input[@id='input-telephone']")
  WebElement tele;
  
  
  @FindBy(xpath="//input[@id='input-password']")
  WebElement txtPassword;
  
  @FindBy(xpath="//input[@id='input-confirm']")
  WebElement confirmPassword;
  
  @FindBy(xpath="//input[@name='agree']")
  WebElement chkPolicy;
  
  @FindBy(xpath="//button[normalize-space()='Continue']")
  WebElement btnContinue;
  
  @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
  WebElement msgConfirmation;
  
  public void enterFirstName(String fname)
  {
	  txtFirstname.sendKeys(fname);
  }
  
  public void enterLastName(String lname)
  {
	  txtLastname.sendKeys(lname); 
  }
  
  public void enterEmail(String email)
  {
	  txtEmail.sendKeys(email); 
  }
  
  public void enterTelephone(String tel)
  {
	  tele.sendKeys(tel);
  }
  
  
  public void enterPassword(String pwd)
  {
	  txtPassword.sendKeys(pwd);
  }
  
  
  public void confirmPassword(String pwd)
  {
	  confirmPassword.sendKeys(pwd);
  }
  
  
  public void chkPolicy()
  {
	  chkPolicy.click();
  }
  
  public void clickContinue()
  {
	  btnContinue.click();
  }
	  
// sol2 //btnContinue.submit();
/* sol3 
Actions act = new Actions(driver)
act.moveToElement(btnContinue).click().perform();
 */  
	  // sol 4
/*JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();btnContinue); */
	
  // btnContinue.sendkeys(Keys.RETURN);
	  
 public String getConfirmationMsg()
  {
    try
    {
    	
    return (msgConfirmation.getText());	
    }	
	 catch(Exception e)
	 {
	   return (e.getMessage());
		 
	 } 
  }  
	  
}
