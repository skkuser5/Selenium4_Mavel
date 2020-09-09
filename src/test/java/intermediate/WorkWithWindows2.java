package intermediate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[starts-with(@name,'name')]")).sendKeys("Roshan");
		String mainWindowHandle = driver.getWindowHandle();
		
		driver.findElement(By.linkText("terms and conditions")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		//for each
		for(String handle:windowHandles)
		{
			
			if(handle.equals(mainWindowHandle))
			{
				//don't do anything
			}
			
			else {
				//child window
				
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("//div[@class='header']//input[@value='OK']")).click();
				break;
				
			}
		}
		
		driver.switchTo().window(mainWindowHandle);
		driver.findElement(By.xpath("//input[starts-with(@name,'login')]")).sendKeys("Roshan2423784328746");
		
		
		

	}

}
