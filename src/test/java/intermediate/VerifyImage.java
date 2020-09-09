package intermediate;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyImage {
	public static void main(String[] args) throws FindFailed, IOException {
		WebDriverManager.firefoxdriver().setup();
				
		WebDriver driver = new FirefoxDriver();
		driver.get("https://dhtmlx.com/docs/products/dhtmlxVault/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("JavaScript"));
		//verify images
		
		WebElement logo_element = driver.findElement(By.xpath("//a[@class='dhx-logo']"));
		File actual_logo = logo_element.getScreenshotAs(OutputType.FILE);
		Pattern actual_logo_pattern = new Pattern(actual_logo.getAbsolutePath());
	
		//read expected logo
		Finder finder = new Finder(ImageIO.read(new File("C:\\Training\\Aug2020\\logo.png")));
		
		finder.find(actual_logo_pattern);
		
		if(finder.hasNext())
		{
			System.out.println("logo is found");
		}
		else
		{
			System.out.println("logo is not found");
		}
		
		
	}

}
