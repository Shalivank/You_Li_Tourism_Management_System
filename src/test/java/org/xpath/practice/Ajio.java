package org.xpath.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
	static WebDriver driver;

	public static void main(String[] args) throws AWTException, EncryptedDocumentException, IOException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.ajio.com");
		// driver.findElement(By.xpath("//span[text()='Allow Location']")).click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		// driver.findElement(By.xpath("//div[@class='ic-close-quickview']")).click();
		// Typographic Print Joggers
		driver.findElement(By.xpath("//a[@title='KIDS']")).click();
		// JavascriptExecutor jse=(JavascriptExecutor)driver;
		// jse.executeScript("window.scrollBy(0,500)"); Micro Print Suit Set
		// driver.findElement(By.xpath("//img[@src='https://assets.ajio.com/cms/AJIO/WEB/19082022-D-KHP-shopbyage-0to2yrs.jpg']")).click();
		driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
		driver.findElement(By.xpath(
				"//div[@class='contentHolder']/div[text()='Cotton Shorts with Insert Pockets']/following-sibling::div/span[@class='price  ']"))
				.click();
		String price = driver.findElement(By.xpath(
				"//div[@class='contentHolder']/div[text()='Cotton Shorts with Insert Pockets']/following-sibling::div/span[@class='price  ']"))
				.getText();
		System.out.println(price);
		// driver.quit();
		FileInputStream fis = new FileInputStream("./src/test/resources/ddt.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell ab = wb.getSheet("ajio").createRow(0).createCell(0);
		ab.setCellValue(price);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/ddt.xlsx");
		wb.write(fos);

	}

}
