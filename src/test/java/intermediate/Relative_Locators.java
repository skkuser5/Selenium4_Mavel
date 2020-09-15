package intermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;


public class Relative_Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String projPath = System.getProperty("user.dir");
		
		
			
	System.setProperty("webdriver.chrome.driver", projPath+"\\src\\test\\resources\\drivers\\"+"chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	
	WebElement currentElement = driver.findElement(By.xpath("//input[contains(@name,'login')]"));
	
	driver.findElement(RelativeLocator.withTagName("input").above(currentElement)).sendKeys("Hello");
	//elementFound.sendKeys("FullName");

	}

}
