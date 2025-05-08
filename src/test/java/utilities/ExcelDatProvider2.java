package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ExcelDatProvider2 {
	
	public void testData (String excelPath,String sheetName) throws IOException
	{
	 
	ExcelNewUtils3_2 excel=new ExcelNewUtils3_2(excelPath, sheetName);
	int rowCount=excel.getRowCount();
	int colCount=excel.getColCount();
	
	for(int i=1;i<rowCount;i++)//1 
       {
	      {
	  	  for (int j=0;j<colCount;j++) //0  i is rows j is col
	 
	  	  {
	  	     // since arrary index starts from 0 that is the reason having [i-1]  // so that i=0 and j=0	
	  		String cellData=excel.getCellDataString( i, j); // i=1,j=0
	  		System.out.print(cellData+"    |   ");
	  		
	  	  }
	  	  
	  	  System.out.println();
	      }
       }
	}
}
	

