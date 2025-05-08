package utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelNewUtils3_1 {
	static String ProjectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelNewUtils3_1 (String excelPath,String sheetName) throws IOException
	{
		
		ProjectPath=System.getProperty("user.dir");
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
	}
	

	public static void getRowCount() throws IOException 
	{
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows:"+rowCount);	
	}
	
	public static void getColCount(int rowNum,int colNum) throws IOException 
	{
		
		int colCount=sheet.getRow(colNum).getPhysicalNumberOfCells();
		System.out.println("Number of cols:"+colCount);	
	}


	public static void getCellDataString(int rowNum,int colNum) throws IOException 
	{
		
		String cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println("String Cell data:"+cellData);	
	}

	public static void getCellDataNumeric(int rowNum,int colNum) throws IOException 
	{
		
		double numericCellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println("Numeric cell data:"+numericCellData);	
	}

	
      
}
