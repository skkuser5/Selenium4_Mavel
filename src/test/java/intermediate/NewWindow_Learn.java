package intermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.hotkey.Keys;

public class NewWindow_Learn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Aug2020\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		String windowHandle = driver.getWindowHandle();
		WebElement products_menu = driver.findElement(By.xpath("(//a[contains(text(),'Products')])[1]"));
		
		
		
		Actions action = new Actions(driver);
		action.moveToElement(products_menu).build().perform();
		
		//WebDriver newWindow = driver.switchTo().newWindow(WindowType.TAB);
		WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
		newWindow.get("https://www.google.com");
		newWindow.findElement(By.name("q")).sendKeys("Angular JS"+Keys.ENTER);
		newWindow.close();
		
		driver.switchTo().window(windowHandle);
		driver.findElement(By.linkText("License")).click();
		
		WebElement header_element = driver.findElement(By.xpath("//h1[text()='Licensing and Pricing']"));
		Rectangle rect = header_element.getRect();
		System.out.println("X " +rect.getX()+" Y "+rect.getY()+ " height "+rect.getHeight()+" width "+rect.getWidth());
		
		
		
		

	}

}
