package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchTheDataFromExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/STC1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet s = workbook.getSheet("Sheet1");
		int count = s.getLastRowNum();
		for(int i=0; i<=count; i++)
		{
			Row row = s.getRow(i);
			String first = row.getCell(0).getStringCellValue();
			String second = row.getCell(1).getStringCellValue();
			System.out.println("first"+  " /t" +"second");
		}

	}

}
