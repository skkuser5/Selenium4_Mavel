package testNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.AnnotationTest;
import listeners.RetryTest;
import listeners.SeleniumListeners;


public class FirstTestNG {
  @Test
  public void testCase1() throws MalformedURLException {
	  WebDriver driver=null;
	//  WebDriverManager.firefoxdriver().setup();
	//	driver = new FirefoxDriver();
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.ANDROID);
	  //cap.setCapability(CapabilityType.brow, value);
	  driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		
	  System.out.println("in testcase1 making changes");
	 // Assert.assertFalse(true);
	  SeleniumListeners listener = new SeleniumListeners();
	  EventFiringWebDriver event = new EventFiringWebDriver(driver);
	 event.register(listener);
	 event.navigate().to("https://phptravels.net/login");
		
	 event.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 event.manage().window().maximize();
	 
	 event.unregister(listener);
	 event.close();
	  
  }
  
  @Test
  public void testCase2() {
	  System.out.println("in testcase2 making changes");
	  Assert.assertFalse(true);
  }
}
