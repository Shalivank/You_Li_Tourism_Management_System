package org.youli.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Userbook {

	public static void main(String[] args) throws InterruptedException {
		String browser = "firefox";
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys("shalivan@gmail.com");
		driver.findElement(By.id("password")).sendKeys("shalivan");
		driver.findElement(By.name("signin")).click();
		driver.findElement(By.xpath("(//a[.='Details'])[last()]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='fromdate']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='26']")).click();
		driver.findElement(By.xpath("//input[@name='todate']")).click();
		driver.findElement(By.xpath("//a[.='31']")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	//	jse.executeScript("window.scrollBy(0,700)");
	//	driver.findElement(By.name("comment")).sendKeys("DASSJLLKJH");
	  //  driver.findElement(By.xpath("//button[.='Book']")).click();
		driver.findElement(By.xpath("//a[.='My Tour History']")).click();
		driver.findElement(By.xpath("//a[.='/ Logout']")).click();
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.className("name")).sendKeys("admin");
		driver.findElement(By.className("password")).sendKeys("Test@123");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//span[.='Manage Booking']")).click();
		driver.findElement(By.xpath("//a[@class='sidebar-icon']")).click();
		jse.executeScript("window.scrollBy(0,3000)");
		driver.findElement(By.xpath("(//table/tbody/tr/td/a[text()='golgumbaj']/../following-sibling::td[6])[last()]")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[.='Welcome']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		driver.findElement(By.xpath("//a[.='Back to home']")).click();
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys("shalivan@gmail.com");
		driver.findElement(By.id("password")).sendKeys("shalivan");
		driver.findElement(By.name("signin")).click();
		driver.findElement(By.xpath("//a[.='My Tour History']")).click();
	//	jse.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='/ Logout']")).click();

	}

}
