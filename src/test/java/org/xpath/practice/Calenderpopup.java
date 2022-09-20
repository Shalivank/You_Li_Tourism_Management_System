package org.xpath.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenderpopup {

	public static void main(String[] args) throws ParseException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		String reqdate = "25";
		String reqmonth = "February 2020";
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
		Date req = sdf.parse(reqmonth);
		while (true) {
			WebElement ele = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
			String text = ele.getText();
			Date current = sdf.parse(text);
			if (text.equalsIgnoreCase(reqmonth)) {
				break;
			} else if (req.after(current)) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			} else {
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}

		}
		driver.findElement(By.xpath("//a[text()='" + reqdate + "']")).click();
	}

}
