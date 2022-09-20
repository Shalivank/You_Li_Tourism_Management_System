package org.Youli.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer {
	int count=0;
	int retries=3;

	@Override
	public boolean retry(ITestResult result) {
		if(count<retries)
		{
			count++;
			return true;
		}
		return false;
	}

}
