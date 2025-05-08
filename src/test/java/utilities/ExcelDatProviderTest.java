package utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDatProviderTest {
	
	WebDriver driver=null;
	@BeforeTest
	public void setUpTest() {
	String ProjectPath = System.getProperty("user.dir");
	driver=new ChromeDriver();
	
	}
	
	
@Test(dataProvider="test1data")
	
	public void test1(String username,String password) throws InterruptedException
	
	{
	System.out.println(username+ "  |  "+password );	
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	
	Thread.sleep(5000);
	}
	
	@DataProvider(name="test1data")
	public Object [][] getData() throws IOException
	{
		String excelPath="C:\\Users\\nguti\\OneDrive\\Desktop\\Automation\\SeleniumWebDriver\\OpenCart\\excel\\data.xlsx"; 
		 Object data [][]=testData(excelPath,"Sheet1");	
		 return data;
		
	}
	
	public  Object [][] testData (String excelPath,String sheetName) throws IOException
	{
	 
	ExcelNewUtils3_2 excel=new ExcelNewUtils3_2(excelPath, sheetName);
	int rowCount=excel.getRowCount();
	int colCount=excel.getColCount();
	
	Object data [][]= new Object[rowCount-1][colCount];  // our array is of object type since it can have different data types
	// rowcount-1 since we not counting header row
	for(int i=1;i<rowCount;i++)//1 
    {
  	  for (int j=0;j<colCount;j++) //0  i is rows j is col
 
  	  {
  		// since arrary index starts from 0 that is the reason having [i-1]  // so that i=0 and j=0	
  		String cellData=excel.getCellDataString( i, j); // i=1,j=0
  		//System.out.print(cellData+"    |   ");
  		data[i-1][j]=cellData;
  	  }
  	  //System.out.println();
    }
	return data;
  }
	
	
//   public static void main(String[] args) throws IOException
//    {
//	
//	 String excelPath="C:\\Users\\nguti\\OneDrive\\Desktop\\Automation\\SeleniumWebDriver\\OpenCart\\excel\\data.xlsx"; 
//	 testData(excelPath,"Sheet1");
//	   
//	   
//    }

}
