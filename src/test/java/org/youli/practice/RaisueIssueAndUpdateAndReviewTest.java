package org.youli.practice;

import java.util.Properties;

import org.Youli.GenericUtilities.DataType;
import org.Youli.GenericUtilities.ExcelUtility;
import org.Youli.GenericUtilities.FileUtility;
import org.Youli.GenericUtilities.IConstantsPath;
import org.Youli.GenericUtilities.JavaUtility;
import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RaisueIssueAndUpdateAndReviewTest {
	public static void main(String[] args) {
		ExcelUtility Eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
		int RandomNumber = ju.getRandomNumber(1000);
		
		String UName = Eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "UserData", 0, 0);
		String UMNum = Eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "UserData", 0, 1);
		String UEmail = Eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "UserData", 0, 2);
		String UPass = Eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "UserData", 0, 3);
		String Browser = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Browser");
		String Url = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "URL");
		String time = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "TimeUnit");
		String AUser = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "AdminUser");
		String APass = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "AdminPassword");
		String UUser = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "UUserName");
		String UPassword = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "UPassword");
		String issue = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "cancellationissue");
		String issuedesc = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "issuedesc");
		String remark = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "remark");
		long longtime = (long)ju.convertStringIntoAnyDatatype(time, DataType.LONG);
		WebDriver driver = wdu.commonOperation(Browser, Url, longtime);
		wdu.initializeJSE(driver);	
		wdu.waitImplicityInSeconds(driver, longtime);
		driver.findElement(By.linkText("/ Sign In")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(UUser);
		driver.findElement(By.id("password")).sendKeys(UPassword);
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		driver.findElement(By.xpath("//a[.=' / Write Us ']")).click();
		WebElement ele = driver.findElement(By.xpath("//select[@name='issue']"));
		wdu.initializeDropDown(ele);
		wdu.waitTillElementIsVisible(driver, longtime, ele);
		driver.findElement(By.xpath("//select[@name='issue']")).click();
		wdu.selectOptionFromDropDownVisibletext(issue);
		String validation = remark+RandomNumber;
		driver.findElement(By.xpath("//input[@name='description']")).sendKeys(issuedesc+RandomNumber);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		driver.findElement(By.xpath("//a[.='/ Logout']")).click();
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(AUser);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(APass);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		driver.findElement(By.xpath("//span[.='Manage Issues']")).click();
		WebElement scrollElement = driver.findElement(By.xpath("(//a[.='View '])[last()]"));
		wdu.scrollUsingJSE(scrollElement);
		scrollElement.click();
		wdu.switchToWindow(driver, "updateissue");
		driver.findElement(By.name("remark")).sendKeys(remark+RandomNumber);
		driver.findElement(By.name("submit2")).click();
		wdu.closeTheTab(driver);
		wdu.switchToWindow(driver, "manage");
		WebElement Scrolltowelcome = driver.findElement(By.xpath("//p[text()='Welcome']"));
		wdu.scrollUsingJSE(Scrolltowelcome);
		Scrolltowelcome.click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		driver.findElement(By.xpath("//a[.='Back to home']")).click();
		driver.findElement(By.linkText("/ Sign In")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(UUser);
		driver.findElement(By.id("password")).sendKeys(UPassword);
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		driver.findElement(By.xpath("//a[.='Issue Tickets']")).click();
		WebElement tablelast = driver.findElement(By.xpath("(//table/descendant::td/ancestor::tr)[last()]"));
		String text = driver.findElement(By.xpath("//tbody/tr/td[.='"+validation+"']")).getText();
		wdu.scrollUsingJSE(tablelast);
		WebElement scrolllogout=driver.findElement(By.xpath("//li[@class='sigi']"));
		wdu.scrollUsingJSE(scrolllogout);
		scrolllogout.click();
		System.out.println(text);
		if(text.equalsIgnoreCase(validation))
		{
			Eu.setValuesToExcel(IConstantsPath.EXCEL_PATH, "TestCase", 2, 3, "Pass");
			System.out.println("TEST CASE IS PASS");
		}
		else
		{
			Eu.setValuesToExcel(IConstantsPath.EXCEL_PATH, "TestCase", 2, 3, "Fail");
			System.out.println("TEST CASE IS FAIL");
		}
		wdu.closeTheBrowser(driver);
	}
}
