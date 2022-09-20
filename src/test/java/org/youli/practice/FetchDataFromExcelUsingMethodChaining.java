package org.youli.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromExcelUsingMethodChaining {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/ddt.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		try {
			String Auser = wb.getSheet("Sheet1").getRow(4).getCell(1).getStringCellValue();
			String Apass = wb.getSheet("Sheet1").getRow(5).getCell(1).getStringCellValue();
			String url = wb.getSheet("Sheet1").getRow(8).getCell(1).getStringCellValue();
			String fullname = wb.getSheet("Sheet1").getRow(10).getCell(1).getStringCellValue();
			String mobileno = wb.getSheet("Sheet1").getRow(11).getCell(1).getStringCellValue();
			String email = wb.getSheet("Sheet1").getRow(12).getCell(1).getStringCellValue();
			String pwd = wb.getSheet("Sheet1").getRow(13).getCell(1).getStringCellValue();
			String browser = "firefox";
			WebDriver driver = null;
			if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

			driver.get(url);
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(fullname);
			driver.findElement(By.xpath("//input[@placeholder='Mobile number']")).sendKeys(mobileno);
			driver.findElement(By.xpath("//input[@placeholder='Email id']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
	//		driver.findElement(By.id("submit")).click();
			driver.findElement(By.xpath("//a[.='Admin Login']")).click();
			driver.findElement(By.className("name")).sendKeys(Auser);
			driver.findElement(By.className("password")).sendKeys(Apass);
			driver.findElement(By.name("login")).click();
		} finally

		{
			wb.close();
		}

	}

}
