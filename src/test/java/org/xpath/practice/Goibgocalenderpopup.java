package org.xpath.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibgocalenderpopup {

	public static void main(String[] args) throws ParseException {
	WebDriverManager.firefoxdriver().setup();
	 WebDriver driver=new FirefoxDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 driver.get("https://www.goibibo.com");
	 driver.findElement(By.xpath("//p[@class='sc-dJjYzT cjzxWN fswWidgetTitle']")).click();
	 String reqMonth = "October 2022";
			 String reqDate = "18";
			 SimpleDateFormat sdf=new SimpleDateFormat("MMMM yyyy");
			 Date req = sdf.parse(reqMonth);
			 
	  while(true)
	  {
		   driver.findElement(By.xpath("//span[.='Departure']/following-sibling::p[@class='sc-dJjYzT cjzxWN fswWidgetTitle']")).click();
		   WebElement ele = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']"));
		  String text = ele.getText();
		  Date current = sdf.parse(text);
		  if(text.equalsIgnoreCase(reqMonth))
		  {
			  break;
		  }
		  else if(req.after(current))
		  {
			  driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			  
		  }
//		  else
//		  {
//			 driver.findElement(By.xpath("//span[@aria-label='Previous Month']")).click();
//		  }
	  }
	driver.findElement(By.xpath("//div[.='"+reqDate+"']")).clear();
	 

	}

}
