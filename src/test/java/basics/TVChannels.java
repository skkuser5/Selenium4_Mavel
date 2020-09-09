package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TVChannels {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Aug2020\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://en.wikipedia.org/wiki/List_of_English-language_television_channels_in_India");
		Thread.sleep(4000);
		
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++)
		{
			System.out.println("index is " +i+" "+ links.get(i).getText());
		}
		
		driver.close();
		

	}

}
