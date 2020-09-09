package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch_Firefox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String browser = "firefox";
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Training\\Aug2020\\drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Training\\Aug2020\\drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		driver.navigate().to("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("nodejs"+Keys.ENTER);
		//Thread.sleep(5000);
		//driver.findElement(By.linkText("Other Downloads")).click();
		driver.findElement(By.partialLinkText("Download")).click();
		//waiting for 5 seconds for the page to load
		Thread.sleep(5000);
		
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
		
		driver.navigate().back();
		
		Thread.sleep(4000);
		
		driver.close();

	}

}
