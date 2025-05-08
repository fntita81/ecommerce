package utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelNewUtils3_2 {
	static String ProjectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelNewUtils3_2 (String excelPath,String sheetName) throws IOException
	{
		
		ProjectPath=System.getProperty("user.dir");
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
	}
	

	public static int getRowCount() throws IOException 
	{
		int rowCount=0;
		try {
		
	    rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows:"+rowCount);	
		
	        }
		catch(Exception e) 
		{
		System.out.println(e.getMessage());
		e.printStackTrace();
		}
		return rowCount;
	}
	
	public static int getColCount() throws IOException 
	{
		int colCount=0;
	try {
		
	    colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of cols:"+colCount);	
		
	   }
	  catch(Exception e) 
	   {
	   System.out.println(e.getMessage());
	   e.printStackTrace();
	  }
	return colCount;
   }


	public static String getCellDataString(int rowNum,int colNum)
	  {
		String cellData=null;
		  try
		   {
		     cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		    // System.out.println("String Cell data:"+cellData);	
		   } 
		    catch(Exception e)
		    {
		    	e.getMessage();
		    }
		return cellData;
			
     }
	 	
	

	public static  double getCellDataNumeric(int rowNum,int colNum) throws IOException 
	{
	
	   	double numericCellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		//System.out.println("Numeric cell data:"+numericCellData);	
		return numericCellData;
	}

	
      
}
