package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String browser= "firefox";
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Aug2020\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("nodejs"+Keys.ENTER);
		//driver.findElement(By.linkText("Other Downloads")).click();
		driver.findElement(By.partialLinkText("Download")).click();
		//waiting for 5 seconds for the page to load
		//Thread.sleep(5000);
		
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
