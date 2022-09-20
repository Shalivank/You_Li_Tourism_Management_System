package org.youli.practice2;

import org.Youli.GenericUtilities.ExcelUtility;
import org.Youli.GenericUtilities.FileUtility;
import org.Youli.GenericUtilities.IConstantsPath;
import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Testcase2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverUtility wdu = new WebDriverUtility();
		FileUtility fu = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		String Auser = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "Sheet1", 4, 1);
		String Apass = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "Sheet1", 5, 1);
		String val = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "browser");
		String url = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "url");
		String Username = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Userusername");
		String password = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Userpassword");
		String comment = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "comment");
		WebDriver driver = wdu.commonOperation(val, url, 10);
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("signin")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)");
		driver.findElement(By.xpath(
				"//h3[.='Package List']/ancestor::div[@class='room-bottom']//h4[.='Package Name: golgumbaj']/../..//a[.='Details']"))
				.click();
		driver.findElement(By.xpath("//input[@name='fromdate']")).click();
		driver.findElement(By.xpath("//a[.='6']")).click();
		driver.findElement(By.xpath("//input[@name='todate']")).click();
		driver.findElement(By.xpath("//a[.='10']")).click();
		jse.executeScript("window.scrollBy(0,3000)");
		driver.findElement(By.name("comment")).sendKeys(comment);
	//    driver.findElement(By.xpath("//button[.='Book']")).click();
	//	driver.findElement(By.xpath("//a[.='My Tour History']")).click();
		driver.findElement(By.xpath("//a[.='/ Logout']")).click();
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.className("name")).sendKeys(Auser);
		driver.findElement(By.className("password")).sendKeys(Apass);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//span[.='Manage Booking']")).click();
		driver.findElement(By.xpath("//a[@class='sidebar-icon']")).click();
//		driver.findElement(By.xpath("(//table/tbody/tr/td/a[text()='golgumbaj']/../following-sibling::td[6])[last()]")).click();
//		Thread.sleep(2000);
//		Alert a = driver.switchTo().alert();
//		a.accept();
		driver.findElement(By.xpath("//p[.='Welcome']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		driver.findElement(By.xpath("//a[.='Back to home']")).click();
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("signin")).click();
		driver.findElement(By.xpath("//a[.='My Tour History']")).click();
		driver.findElement(By.xpath("(//table/tbody/tr/td/a[text()='golgumbaj']/../following-sibling::td[6])[last()]")).click();

	}

}
