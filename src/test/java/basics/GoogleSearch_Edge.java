package basics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import util.ReadProperties;

public class GoogleSearch_Edge {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "C:\\Training\\Aug2020\\drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get(ReadProperties.readProperty("URL"));
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("nodejs"+Keys.ENTER);
		Thread.sleep(5000);
		//driver.findElement(By.linkText("Other Downloads")).click();
		driver.findElement(By.partialLinkText("s")).click();
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
		
		driver.close();

	}

}
