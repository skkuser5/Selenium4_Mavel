package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.ITest;

public class AnnotationTest implements IAnnotationTransformer{
	
//	@Override
//	public void transform(ITest annotation, Class testClass,
//		      Constructor testConstructor, Method testMethod)
//	{
//		Class retryAnalyzerClass = annotation.getRetryAnalyzerClass();
//		if(retryAnalyzerClass!=RetryTest.class) {
//			annotation.setRetryAnalyzer(RetryTest.class);
//		}
//	}
	
	

}
