package org.xpath.practice;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lara {
      @Test
	public void login() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://122.166.192.191:9003");
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.id("email")).sendKeys("abcdef@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456789");
		driver.findElement(By.id("loginBtn")).click();
		WebElement ele = driver.findElement(By.xpath("(//a[contains(.,'sharath')])[2]"));
		
        Assert.assertTrue(ele.isDisplayed(),"true");
        System.out.println("true");
        
	}

}
