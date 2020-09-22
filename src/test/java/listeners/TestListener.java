package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("On test failure");
		
		ITestContext testContext = result.getTestContext();
		WebDriver driver = (WebDriver)testContext.getAttribute("driver");
		
		TakesScreenshot scr= (TakesScreenshot)driver;
		File fullScreenshot = scr.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(fullScreenshot, new File("C:\\Training\\Aug2020\\workspace\\Selenium4_Maven\\src\\test\\resources\\screenshots\\elementSS.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	

}
