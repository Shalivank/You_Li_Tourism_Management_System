package org.testNGParallel.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTest {
	@BeforeSuite
	public void BeforeSuite()
	{
		Reporter.log("this is beforesuite", true);  
	}
	@BeforeTest
	public void BeforeTest()
	{
		Reporter.log("this is beforetest", true);   
	}
	@BeforeClass
	public void BeforeClass()
	{
		Reporter.log("this is beforeclass", true);
	}
	@BeforeMethod
	public void BeforeMethod()
	{
		Reporter.log("this is beforemethod", true);
	}
	@Test
	public void Test()
	{
		Reporter.log("this is TestAnnotation", true);
	}
	@AfterMethod
	public void AfterMethod()
	{
		Reporter.log("this is aftermethod", true);
	}
	@AfterClass
	public void AfterClass()
	{
		Reporter.log("this is afterclass", true);
	}
	@AfterTest
	public void AfterTest()
	{
		Reporter.log("this is aftertest", true);
	}
	@AfterSuite
	public void AfterSuite()
	{
		Reporter.log("this is aftersuite", true);
	}

}
