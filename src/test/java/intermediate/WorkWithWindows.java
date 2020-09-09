package intermediate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.manage().window().maximize();
		
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println(mainWindowHandle);
		
		driver.findElement(By.xpath("(//a/img[@src='/images/login.png'][@title='LOGIN NOW'])[1]")).click();
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String handle:windowHandles)
		{
			
			if (handle.equals(mainWindowHandle))
			{
				//don't do anything
			}
			else
			{
				driver.switchTo().window(handle);
				driver.findElement(By.id("User_Id")).sendKeys("Testuser");
				Thread.sleep(3000);
				driver.close();
				break;
			}
		}
		
		
		driver.switchTo().window(mainWindowHandle);
		driver.findElement(By.linkText("APPLY FOR CREDIT CARDS")).click();
		
		
		
	}

}
