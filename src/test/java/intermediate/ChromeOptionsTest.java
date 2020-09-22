package intermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsTest {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Aug2020\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://expired.badssl.com/");
		
		
	}

}
