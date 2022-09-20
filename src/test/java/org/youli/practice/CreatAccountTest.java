package org.youli.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatAccountTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		String browser = "Chrome";
		switch (browser) {
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			break;
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("please enter valid browser");
			break;

		}
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.findElement(By.xpath("//a[.='Sign Up']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("qwert");
		driver.findElement(By.xpath("//input[@placeholder='Mobile number']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@placeholder='Email id']")).sendKeys("qwert@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("qwert12");
		driver.findElement(By.id("submit")).click();

	}

}
