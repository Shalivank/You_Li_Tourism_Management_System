package org.youli.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromPropertiesFile {
	static WebDriver driver = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties property = new Properties();
		property.load(fis);
		String url = property.getProperty("url");
		String adminun = property.getProperty("Adminusername");
		String adminpass = property.getProperty("adminpassword");
		/*
		 * System.out.println(url); System.out.println(adminun);
		 * System.out.println(adminpass);
		 */
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(url);
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.className("name")).sendKeys(adminun);
		driver.findElement(By.className("password")).sendKeys(adminpass);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//i[@aria-hidden='true' and@class='fa fa-list-ul']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Create']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("packagename")).sendKeys("guttenhalli gudda");
		driver.findElement(By.name("packagetype")).sendKeys("family and couples");
		driver.findElement(By.name("packagelocation")).sendKeys("Gouribidnoor");
		driver.findElement(By.name("packageprice")).sendKeys("5$");
		driver.findElement(By.name("packagefeatures")).sendKeys("free pickup and drop accomndation");
		driver.findElement(By.name("packagedetails")).sendKeys("good place");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\user\\Desktop\\coorg-hill-station1.jpg");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[.='Create']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@aria-hidden='true' and@class='fa fa-list-ul']")).click();
		driver.findElement(By.xpath("//a[.='Manage']")).click();
		driver.findElement(By.xpath("(//button[.='View Details'])[last()]")).click();
	   
	}

}
