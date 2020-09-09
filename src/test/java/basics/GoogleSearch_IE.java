package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GoogleSearch_IE {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.ie.driver", "C:\\Training\\Aug2020\\drivers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("nodejs"+Keys.ENTER);
		
		
		
		//driver.findElement(By.linkText("Other Downloads")).click();
		driver.findElement(By.partialLinkText("India")).click();
		//waiting for 5 seconds for the page to load
		
		
		String title=driver.getTitle();
		String currentURL=driver.getCurrentUrl();
		
		if(title.contains("Download"))
		{
			System.out.println("title PASS");
		}
		else
		{
			System.out.println("title FAIL");
		}
		
		if(currentURL.contains("download"))
		{
			System.out.println("URL PASS");
		}

		else
		{
			System.out.println("URL FAIL");
		}
		System.out.println("title " +title);
		System.out.println("currentURL " +currentURL);
		
		driver.close();

	}

}
