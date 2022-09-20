package org.youli.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/ddt.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		try
		{
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(4);
		Cell cell = row.getCell(1);
		String data = cell.getStringCellValue();// numeric values we  use getnumericcellvalue();
		System.out.println(data);
		}
		finally
		{
			wb.close();
		}
	}
}
