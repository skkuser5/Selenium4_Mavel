package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class MethodInvoke implements IInvokedMethodListener {
	
	public void 	afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("after invokation");
		
	}

	
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("before invokation");
	}
}
