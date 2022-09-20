package org.xpath.practice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelPractice1 ex=new ExcelPractice1();
		List<Map<String, String>> val = ex.getMultipleDataFromExcel("package details");
		System.out.println(val);
	}
}

