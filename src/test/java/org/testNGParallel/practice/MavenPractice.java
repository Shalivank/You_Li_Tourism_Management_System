package org.testNGParallel.practice;

import org.Youli.GenericUtilities.WebDriverUtility;
import org.testng.annotations.Test;

public class MavenPractice {
	@Test
	public void Test() {
		String browser = System.getProperty("b");
		String url = System.getProperty("u");
//		System.out.println("browser name is========>>>> "+browser);
//		System.out.println("url name is========>>>> "+url);
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.commonOperation(browser, url, 10);
	}

}
