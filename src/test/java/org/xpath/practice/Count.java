package org.xpath.practice;

import org.Youli.GenericUtilities.ExcelUtility;
import org.Youli.GenericUtilities.FileUtility;
import org.Youli.GenericUtilities.IConstantsPath;
import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Count {

	public static void main(String[] args) {
		WebDriverUtility wdu = new WebDriverUtility();
		FileUtility fu = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		String val = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "browser");
		String url = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "url");
		String Auser = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "Sheet1", 4, 1);
		String Apass = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "Sheet1", 5, 1);
		String Username = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Userusername");
		String password = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Userpassword");
		String comment = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "comment");
		WebDriver driver = wdu.commonOperation(val, url, 10);
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.className("name")).sendKeys(Auser);
		driver.findElement(By.className("password")).sendKeys(Apass);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//span[.='Manage Booking']")).click();
		driver.findElement(By.xpath("//a[@class='sidebar-icon']")).click();
		WebElement ele = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[@data-th='Booikn id']"));
		int yaxis = wdu.scrollToElement(ele);
		wdu.scrollAction(driver, 0, yaxis);
		String text = ele.getText();
		String fString = text.toString();
		String[] str = fString.split("-");
		System.out.println(str[1]);
		WebElement sc = driver.findElement(By.xpath("//p[.='Welcome']"));
		wdu.scrollUsingJSE(sc);
		driver.findElement(By.xpath("//p[.='Welcome']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		driver.findElement(By.xpath("//a[.='Back to home']")).click();
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("signin")).click();
		WebElement view = driver.findElement(By.xpath("//h4[.='Package Name: mysuru palace']"));
		wdu.scrollUsingJSE(view);
		driver.findElement(By.xpath("//h3[.='Package List']/ancestor::div[@class='room-bottom']//h4[.='Package Name: mysuru palace']/../..//a[.='Details']")).click();
		driver.findElement(By.xpath("//input[@name='fromdate']")).click();
		driver.findElement(By.xpath("//a[.='10']")).click();
		driver.findElement(By.xpath("//input[@name='todate']")).click();
		driver.findElement(By.xpath("//a[.='0']")).click();
		WebElement upc = driver.findElement(By.name("comment"));
		wdu.scrollUsingJSE(upc);
		driver.findElement(By.name("comment")).sendKeys(comment);
	    driver.findElement(By.xpath("//button[.='Book']")).click();
	    WebElement ele1 = driver.findElement(By.xpath("//a[.='/ Logout']"));
	    wdu.scrollUsingJSE(ele1);
	    driver.findElement(By.xpath("//a[.='/ Logout']")).click();
	    driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.className("name")).sendKeys(Auser);
		driver.findElement(By.className("password")).sendKeys(Apass);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//span[.='Manage Booking']")).click();
		driver.findElement(By.xpath("//a[@class='sidebar-icon']")).click();
		WebElement ele11 = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[@data-th='Booikn id']"));
	    wdu.scrollUsingJSE(ele11);
	    String text1 = ele11.getText();
	    String abook = text1.toString();
	    String[] str1 = abook.split("-");
	    System.out.println(str1[1]);
	    String xyz = str[1];
	    String abc = str1[1];
	    int convertedint = Integer.parseInt(abc);
	   int convertedintBefore = Integer.parseInt(xyz);
         if(convertedint>convertedintBefore)
         {
        	 System.out.println("tc is pass");
         }
         else
         {
        	 System.out.println("tc is fail");
         }
         wdu.closeTheBrowser(driver);
	}

}
