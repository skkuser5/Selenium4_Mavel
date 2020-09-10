package testNG;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WorkWithAlert {
	
	WebDriver driver;
	@Parameters({"browserName"})
	@BeforeTest
	public void beforeTest(String browserName) {
		
		if(browserName.equals("chrome"))
		{
			System.out.println("beforeMethod");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox"))
		{
			System.out.println("beforeMethod");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("edge"))
		{
			System.out.println("beforeMethod");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://dhtmlx.com/docs/products/dhtmlxVault/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("JavaScript"));
		
	}
	
	@Test(invocationCount = 3)
	public void verifyAlert() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://retail.onlinesbi.com/retail/login.htm");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("CONTINUE TO LOGIN")).click();
		driver.findElement(By.id("Button2")).click();
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		Assert.assertEquals(text,"Enter username","verify alert");
		Thread.sleep(2000);
		alert.accept();
		
		driver.close();

		
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after Method");
		driver.close();
	}

	
}
