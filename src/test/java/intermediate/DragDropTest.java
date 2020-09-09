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

public class DragDropTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Aug2020\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		WebElement src_element = driver.findElement(By.xpath("//span[text()='Learning DHTMLX Suite UI']"));
		WebElement dest_element = driver.findElement(By.xpath("//*[@id=\"treeTarget\"]/ul"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(src_element));

		Thread.sleep(5000);

		Actions actions = new Actions(driver);
		// actions.dragAndDrop(src_element, dest_element).build().perform();

		actions.clickAndHold(src_element).moveToElement(dest_element).release(dest_element).build().perform();

	}

}
