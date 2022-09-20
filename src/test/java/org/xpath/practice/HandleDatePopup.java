package org.xpath.practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDatePopup {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String reqdate = "29";// DD
		String reqmonth = "February";// MMMM //MMM //MM
		String reqyear = "2021";// YYYY
		int reqmonthinnum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqmonth)
				.get(ChronoField.MONTH_OF_YEAR);
		int reqyearinnum = Integer.parseInt(reqyear);
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		String actualmonthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String[] str = actualmonthyear.split(" ");
		String actualmonth = str[0];
		String actualyear = str[1];
		int actualmonthinnum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualmonth)
				.get(ChronoField.MONTH_OF_YEAR);
		int actualyearinnum = Integer.parseInt(actualyear);
		while (reqmonthinnum > actualmonthinnum || reqyearinnum > actualyearinnum) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualmonthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = actualmonthyear.split(" ");
			actualmonth = str[0];
			actualyear = str[1];
			reqmonthinnum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqmonth)
					.get(ChronoField.MONTH_OF_YEAR);
			actualmonthinnum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualmonth)
					.get(ChronoField.MONTH_OF_YEAR);
			reqyearinnum = Integer.parseInt(reqyear);
			actualyearinnum = Integer.parseInt(actualyear);
		}
		while (reqmonthinnum < actualmonthinnum || reqyearinnum < actualyearinnum) {
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			actualmonthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = actualmonthyear.split(" ");
			actualmonth = str[0];
			actualyear = str[1];
			reqmonthinnum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqmonth)
					.get(ChronoField.MONTH_OF_YEAR);
			actualmonthinnum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualmonth)
					.get(ChronoField.MONTH_OF_YEAR);
			reqyearinnum = Integer.parseInt(reqyear);
			actualyearinnum = Integer.parseInt(actualyear);
		}
		driver.findElement(By.xpath("//a[text()='" + reqdate + "']")).click();

	}

}
