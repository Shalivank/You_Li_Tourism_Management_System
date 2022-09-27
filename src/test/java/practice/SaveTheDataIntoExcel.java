package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SaveTheDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/STC1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		workbook.getSheet("Sheet1").createRow(6).createCell(6).setCellValue("shalivan");
		FileOutputStream fout=new FileOutputStream("./src/test/resources/STC1.xlsx");
		workbook.write(fout);
		String result = workbook.getSheet("Sheet1").getRow(6).getCell(6).getStringCellValue();
		System.out.println(result);

	}

}
