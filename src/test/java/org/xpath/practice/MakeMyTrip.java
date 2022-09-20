package org.xpath.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	static WebDriver driver;

	public static void main(String[] args) throws EncryptedDocumentException, IOException, AWTException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileInputStream fis=new FileInputStream("./src/test/resources/ddt.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String fromcity = wb.getSheet("makemytrip").getRow(1).getCell(0).getStringCellValue();
		String tocity = wb.getSheet("makemytrip").getRow(1).getCell(1).getStringCellValue();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromcity);
		driver.findElement(By.xpath("//div[.='"+fromcity+"']")).click();	
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(tocity);
		driver.findElement(By.xpath("//div[.='"+tocity+"']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();
		driver.close();

	}

}
