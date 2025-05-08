package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders2 {
	
	
	 @DataProvider(name="LoginData")
     public String [][] getData() throws IOException
     
     { 
		 // taking xl file from testData
       String path=System.getProperty("user.dir")+"\\testData\\LoginTestData.xlsx";
    		
    
      ExcelUtility xlutil=new ExcelUtility(path);// creating an object for xl utility class (initialize excel utility)
       
      // Get total rows and columns
      int totalRows=xlutil.getRowCount("Sheet1");
      int totalCols=xlutil.getCellCount("Sheet1",1); 
      
      // initialize a 2 Dimensional array to store data
      
      String logindata[][]=new String[totalRows-1][totalCols];// created a two dimension array and passed total number of rows and columns 
      
      // checking for empty rows and columns
      
      if (totalRows == 0 || totalCols == 0)
        {
    	    throw new IOException("No data found in the Excel sheet.");
    	}

      // Read data from Excel into the array
      
      
      
      for(int i=1;i<=totalRows;i++)//1 
      {
    	  for (int j=0;j<totalCols;j++) //0  i is rows j is col
   
    	  {
    		// since arrary index starts from 0 that is the reason having [i-1]
    		  // so that i=0 and j=0
    		logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j); // i=1,j=0
    	  }
      }
        
      // Print the data for debugging purposes
      System.out.println("Data fetched from Excel:");
      for (String[] row : logindata)
      {
          System.out.println(java.util.Arrays.toString(row));
      }

      // Return the data
      return logindata;
  }
	 
	 
}
	 // DataProvider 2
	 // DataProvider 3
	 // DataProvider 4
	 
	 
	 
	 
	 


