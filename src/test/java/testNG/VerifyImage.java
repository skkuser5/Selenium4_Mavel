package testNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyImage {
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
	
	
	
	@Test(priority=0)
	public void verifyTitle() throws IOException {
		
		
		//verify images
		
		Assert.assertEquals(driver.getTitle(), "JavaScript File Uploader with Progress Bar - dhtmlxVault","verify title");
		
		
	}
	
	
	@Test(priority=1,enabled=false)
	public void verifyIcon() throws IOException {
		
		//verify images
		
		WebElement logo_element = driver.findElement(By.xpath("//a[@class='dhx-logo']"));
		File actual_logo = logo_element.getScreenshotAs(OutputType.FILE);
		Pattern actual_logo_pattern = new Pattern(actual_logo.getAbsolutePath());
	
		//read expected logo
		Finder finder = new Finder(ImageIO.read(new File("C:\\Training\\Aug2020\\logo.png")));
		
		finder.find(actual_logo_pattern);
		
		
		Assert.assertTrue(finder.hasNext(), "logo is not found");
		
		
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after Method");
		driver.close();
	}
	
	

}
