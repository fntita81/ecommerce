package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelNewUtils {
	
	public static void getCellCount(String filePath, String sheetName, int rowNumber) throws IOException 
	{
        FileInputStream fi = null;
        XSSFWorkbook workbook = null;
        try {
            fi = new FileInputStream(filePath); // Open the Excel file
            workbook = new XSSFWorkbook(fi);   // Create Workbook instance
            XSSFSheet sheet = workbook.getSheet(sheetName); // Access the specified sheet
            
            if (sheet == null) {
                System.out.println("Sheet " + sheetName + " does not exist.");
                return;
            }

            XSSFRow row = sheet.getRow(rowNumber); // Access the specified row
            if (row == null) {
                System.out.println("Row " + rowNumber + " does not exist in sheet " + sheetName);
                return;
            }

            int cellCount = row.getLastCellNum(); // Get total number of cells
            System.out.println("Total cells in row " + rowNumber + ": " + cellCount);
        } finally {
            if (workbook != null) workbook.close(); // Close Workbook
            if (fi != null) fi.close();           // Close FileInputStream
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = ".\\testData\\LoginTestData.xlsx";
        String sheetName = "Sheet1";
        int rowNumber = 1;

        getCellCount(filePath, sheetName, rowNumber);
    }
	
	

}
