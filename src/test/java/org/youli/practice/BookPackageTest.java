package org.youli.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookPackageTest{

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
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.className("name")).sendKeys("admin");
		driver.findElement(By.className("password")).sendKeys("Test@123");
		driver.findElement(By.name("login")).click();
		String value = driver.findElement(By.xpath("//div[@class='four-wthree']/div[@class='icon']")).getText();
		System.out.println(value);
		driver.findElement(By.xpath("//i[@aria-hidden='true' and@class='fa fa-list-ul']")).click();
		driver.findElement(By.xpath("//a[.='Create']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("packagename")).sendKeys(" gudda");
		driver.findElement(By.name("packagetype")).sendKeys("family and couples");
		driver.findElement(By.name("packagelocation")).sendKeys("Gouribidnoor");
		driver.findElement(By.name("packageprice")).sendKeys("285$");
		driver.findElement(By.name("packagefeatures")).sendKeys("free pickup and drop accomndation");
		driver.findElement(By.name("packagedetails")).sendKeys("good place");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\user\\Desktop\\coorg-hill-station1.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Create']")).click();
		Thread.sleep(2000);
		String ele = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		System.out.println(ele);
		driver.findElement(By.xpath("//i[@aria-hidden='true' and@class='fa fa-list-ul']")).click();
		driver.findElement(By.xpath("//a[.='Manage']")).click();
		driver.findElement(By.xpath("(//button[.='View Details'])[last()]")).click();

	}

}
