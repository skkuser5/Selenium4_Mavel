package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{
	int retryCount=0;
	int maxCount=5;

	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCount<maxCount)
		{
			retryCount++;
			return true;
		}
		return false;
	}

}
