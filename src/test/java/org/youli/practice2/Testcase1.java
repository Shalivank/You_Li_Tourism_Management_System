package org.youli.practice2;

import org.Youli.GenericUtilities.ExcelUtility;
import org.Youli.GenericUtilities.FileUtility;
import org.Youli.GenericUtilities.IConstantsPath;
import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Testcase1 {

	public static void main(String[] args) {
		WebDriverUtility wdu = new WebDriverUtility();
		FileUtility fu = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		String val = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "browser");
		String url = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "url");
		WebDriver driver = wdu.commonOperation(val, url, 10);
		String Auser = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "Sheet1", 4, 1);
		String Apass = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "Sheet1", 5, 1);
		String packagename = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 0, 1);
		String packagetype = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 1, 1);
		String packagelocation = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 2, 1);
		String packageprice = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 3, 1);
		String packagefeatures = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 4, 1);
		String packagedetails = eLib.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 5, 1);
		driver.get(url);
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.className("name")).sendKeys(Auser);
		driver.findElement(By.className("password")).sendKeys(Apass);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//i[@aria-hidden='true' and@class='fa fa-list-ul']")).click();
		driver.findElement(By.xpath("//a[.='Create']")).click();
		driver.findElement(By.name("packagename")).sendKeys(packagename);
		driver.findElement(By.name("packagetype")).sendKeys(packagetype);
		driver.findElement(By.name("packagelocation")).sendKeys(packagelocation);
		driver.findElement(By.name("packageprice")).sendKeys(packageprice);
		driver.findElement(By.name("packagefeatures")).sendKeys(packagefeatures);
		driver.findElement(By.name("packagedetails")).sendKeys(packagedetails);
		driver.findElement(By.xpath("//input[@type='file']"))
				.sendKeys("C:\\Users\\user\\Desktop\\coorg-hill-station1.jpg");
     	driver.findElement(By.xpath("//button[.='Create']")).click();
		driver.findElement(By.xpath("//i[@aria-hidden='true' and@class='fa fa-list-ul']")).click();
		driver.findElement(By.xpath("//a[.='Manage']")).click();
		driver.findElement(By.xpath("//table[@id='table']/descendant::td[contains(.,'" + packagename
				+ "')]/ancestor::tr/td[@data-th='Action']/descendant::button[.='View Details']")).click();
		driver.findElement(By.xpath("//p[.='Welcome']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		wdu.closeTheBrowser(driver);

	}

}
