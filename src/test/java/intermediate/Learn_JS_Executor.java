package intermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learn_JS_Executor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String projPath = System.getProperty("user.dir");
		
		
		
		System.setProperty("webdriver.chrome.driver", projPath+"\\src\\test\\resources\\drivers\\"+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.rediff.com/");
		
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String string = jse.executeScript("return document.title;").toString();
		System.out.println(string);

		//jse.executeScript("window.scrollBy(0,500);");
		
		//Thread.sleep(5000);
		
		//jse.executeScript("window.scrollBy(0,-500);");
		
		WebElement link = driver.findElement(By.linkText("SEE: RCB salutes Covid Hero Ganesh Nayak"));
		
		jse.executeScript("arguments[0].scrollIntoView(true);", link);
		
		Thread.sleep(5000);
		
		jse.executeScript("arguments[0].click();", link);
		
		

	}

}
