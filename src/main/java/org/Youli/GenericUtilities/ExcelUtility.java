package org.Youli.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

/**
 * This class is consists of all common action on excel
 * 
 * @author SHALIVAN KHANDRE
 *
 */

public class ExcelUtility {
	
	FileInputStream fis = null;
	FileOutputStream fos = null;
	Workbook wb;
	Sheet sheet;
	public void openExcel(String pathOfExcel,String sheetName)
	{

		try {
			fis = new FileInputStream(pathOfExcel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {

			wb = WorkbookFactory.create(fis);
			sheet=wb.getSheet(sheetName);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

	}

	public String getexcel(int rownum,int cellnum)
	{
		DataFormatter df=new DataFormatter();
		return df.formatCellValue(sheet.getRow(rownum).getCell(cellnum));
	}

	public void writetoexcel(String value,int rownum,int cellnum,String pathofExcel)
	{
		sheet.getRow(rownum).createCell(cellnum).setCellValue(value);
		try {
			fos = new FileOutputStream(pathofExcel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void closeExcel()
	{
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to fetch the multiple data from excel using map
	 * @param sheetName
	 * @return
	 */
	public List<Map<String, String>> getMultipleDataFromExcelUsingMap(String sheetName)
	{
	Sheet sheet = wb.getSheet(sheetName);
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


	/**
	 * getValuesFromExcel Method Fetches Values From Specified WorkBook,SheetName,RowNumber,CellNumber
	 * Using Following Parameters and Returns Value To The Calling Program
	 * @param Path
	 * @param SheetName
	 * @param Rownumber
	 * @param Cellnumber
	 * @return
	 */
	public String getValuesFromExcel(String pathOfExcel,String sheetName,int rowNumber,int cellNumber)
	{

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(pathOfExcel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook workBook = null;
		try {
			workBook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		Sheet OpenSheet = workBook.getSheet(sheetName);
		DataFormatter DF=new DataFormatter();
		String FetchedData = DF.formatCellValue(OpenSheet.getRow(rowNumber).getCell(cellNumber));
		try {
			workBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FetchedData;		
	}

	/**
	 * setValuesToExcel Method Writes Value To Specified WorkBook,SheetName,RowNumber,CellNumber
	 * By Using Following Parameters
	 * @param Path
	 * @param SheetName
	 * @param Rownumber
	 * @param Cellnumber
	 * @return
	 */
	public void setValuesToExcel(String pathOfExcel,String sheetName,int rowNumber,int cellNumber,String value)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(pathOfExcel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Workbook workBook = null;
		try {
			workBook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		Sheet Opensheet = workBook.getSheet(sheetName);
		Opensheet.getRow(rowNumber).createCell(cellNumber).setCellValue(value);
		try {
			FileOutputStream fos=new FileOutputStream(pathOfExcel);
			try {
				workBook.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}