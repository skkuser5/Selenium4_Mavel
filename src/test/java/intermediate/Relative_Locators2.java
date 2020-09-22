package intermediate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Relative_Locators2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String projPath = System.getProperty("user.dir");
		
	ChromeOptions options = new ChromeOptions();
	options.setHeadless(true);
			
	System.setProperty("webdriver.chrome.driver", projPath+"\\src\\test\\resources\\drivers\\"+"chromedriver.exe");
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.rediff.com/");
	
	WebElement newsLink = driver.findElement(By.linkText("NEWS"));
	
	//List<WebElement> findElement = driver.findElements(RelativeLocator.withTagName("a").toRightOf(newsLink));
	//elementFound.sendKeys("FullName");
	
	List<WebElement> findElement = driver.findElements(RelativeLocator.withTagName("a").toLeftOf(newsLink));
	
	for(WebElement element: findElement)
	{
		System.out.println(element.getText());
	}

	}

}
