package intermediate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHover {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Aug2020\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		WebElement products_menu = driver.findElement(By.xpath("(//a[contains(text(),'Products')])[1]"));
		WebElement pivot_submenu = driver.findElement(By.xpath("//span[text()='Pivot']"));
		
		
		Actions action = new Actions(driver);
		action.moveToElement(products_menu).build().perform();
		//pivot_submenu.click();
		
		action.doubleClick(pivot_submenu).build().perform();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Pivot"));
		
		if(driver.getTitle().equals("Javascript Pivot Table - dhtmlxPivot"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
	}
}
