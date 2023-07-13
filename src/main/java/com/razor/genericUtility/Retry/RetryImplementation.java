package com.razor.genericUtility.Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class will execute whenever test case is failed it will retry until the test case is pass
 * @author Vishwanath-Naik
 *
 */
public class RetryImplementation implements IRetryAnalyzer{
	int count;
	@Override
	public boolean retry(ITestResult result) {
		int maxCount=2;
		if(count<maxCount) {
			count++;
			return true;
		}
		return false;
	}
}
