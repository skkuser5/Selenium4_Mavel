package intermediate;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Aug2020\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?");
		
		WebElement element = driver.findElement(By.xpath("//img[contains(@src,'logo.jpg')]"));
		File screenshot = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Training\\Aug2020\\workspace\\Selenium4_Maven\\src\\test\\resources\\screenshots\\screenshot.png"));
	
	
		TakesScreenshot scr= (TakesScreenshot)driver;
		File fullScreenshot = scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fullScreenshot, new File("C:\\Training\\Aug2020\\workspace\\Selenium4_Maven\\src\\test\\resources\\screenshots\\fullscreen.png"));
	}

}
