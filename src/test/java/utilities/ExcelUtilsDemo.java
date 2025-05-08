package utilities;

import java.io.IOException;

public class ExcelUtilsDemo {

	public static void main(String[] args) throws IOException {
		String ProjectPath=System.getProperty("user.dir");
		ExcelNewUtils3_1 excel= new ExcelNewUtils3_1(ProjectPath+"/excel/data.xlsx","Sheet1");

		excel.getRowCount();
		//excel.getCellDataNumeric(1, 1);
		excel.getCellDataString(0,2);
	}

}
