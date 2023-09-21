package qa.testScripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestReadData {
	
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\adith\\eclipse-workspace\\ReadingDataFromExcel\\src\\test\\resources\\TestData\\EmpData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		
		for(int i = 0;i<rowcount;i++) {
			XSSFRow currentrow = sheet.getRow(i);
			for(int j=0; j<colcount;j++) {
				String Data = currentrow.getCell(j).toString();
				System.out.println(Data + " ");
			}
			System.out.println();
		}
		

		
	}

}
