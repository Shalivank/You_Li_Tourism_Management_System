package org.xpath.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelPractice1 {
	
	public List<Map<String, String>> getMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/ddt.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		List<Map<String, String>> list=new ArrayList<>();
		DataFormatter df=new DataFormatter();
		for(int i=1; i<sheet.getRow(0).getLastCellNum();i++)
		{
			Map<String, String> map=new HashMap<>();
			for(int j=0; j<=sheet.getLastRowNum();j++)
			{
				map.put(df.formatCellValue(sheet.getRow(j).getCell(0)), df.formatCellValue(sheet.getRow(j).getCell(i)));
			}
			list.add(map);
		}
		
		return list;
	}

}
