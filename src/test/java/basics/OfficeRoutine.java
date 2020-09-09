package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OfficeRoutine {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Aug2020\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Training/Aug2020/Work_HTML.html");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		WebElement element=driver.findElement(By.xpath("/html/body/form[1]/input[1]"));
		String nameoutput = element.getAttribute("name");
		String type=element.getAttribute("type");
		System.out.println(nameoutput);
		System.out.println(type);
		
		if(element.isDisplayed())
		{
			System.out.println("Today I came to office option is displayed");
		}
		else
		{
			System.out.println("Fail!!! Today I came to office option is not displayed");
		}
		
		if(element.isSelected())
		{
			System.out.println("Today I came to office option is selected");
		}else
		{
			System.out.println("Fail!!! Today I came to office option is not selected");
		}

		
		if(element.isEnabled())
		{
			System.out.println("Fail!!! Today I came to office option is enabled");
		}else
		{
			System.out.println("Pass!!! Today I came to office option is not enabled");
		}

	}

}
