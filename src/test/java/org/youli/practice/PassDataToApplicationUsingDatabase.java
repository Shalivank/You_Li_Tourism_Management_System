package org.youli.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PassDataToApplicationUsingDatabase {

	public static void main(String[] args) throws SQLException {
		Driver dbdriver = new Driver();
		DriverManager.registerDriver(dbdriver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet username = statement.executeQuery("select username from details;");
		String un = null;
		String pwd = null;
		for (int i = 1; i <= 1; i++) {
			if (i == 1) {
				while (username.next()) {
					un = username.getString("username").trim();
					System.out.println(un);
					break;
				}
			}
		}
		ResultSet password = statement.executeQuery("select password from details;");
		for (int i = 0; i <= 1; i++) {
			if (i == 1) {
				while (password.next()) {
					pwd = password.getString("password").trim();
					System.out.println(pwd);
					break;
				}
			}
		}
//		String browser = "firefox";
//		WebDriver driver = null;
//		if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		} else if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
//		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(un);
//		driver.findElement(By.id("password")).sendKeys(pwd);
//		driver.findElement(By.name("signin")).click();

	}

}
