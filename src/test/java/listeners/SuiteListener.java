package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener{
	
	public void onFinish(ISuite suite)
	{
		System.out.println("on Finish");
	}
	
	public void onStart(ISuite suite)
	{
		System.out.println("on Start");
	}

}
