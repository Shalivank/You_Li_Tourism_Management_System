package org.youli.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManagePagesTest {

	public static void main(String[] args) throws SQLException, InterruptedException, AWTException {
		WebDriver driver = null;
		String browser = "Firefox";
		switch (browser) {
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
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
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.className("name")).sendKeys("admin");
		driver.findElement(By.className("password")).sendKeys("Test@123");
		driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//a[@href='manage-pages.php']")).click();
        driver.findElement(By.name("menu1")).click();
        driver.findElement(By.xpath("//option[.='terms and condition']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[@align='justify'][1]")).click();
        driver.findElement(By.xpath("//div[.='Font Size...']")).click();
        driver.findElement(By.xpath("//font[@size='4']")).click();
        driver.findElement(By.xpath("//div[.='Font Family...']")).click();
        driver.findElement(By.xpath("//font[.='Comic Sans']")).click();   
        driver.findElement(By.xpath("//p[@align='justify'][1]")).click();
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_A);
        r.keyRelease(KeyEvent.VK_A);
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        driver.findElement(By.xpath("//p[.='Welcome']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}

}
