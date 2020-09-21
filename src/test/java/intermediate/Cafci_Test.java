package intermediate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cafci_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Training\\Aug2020\\drivers\\geckodriver.exe");
		//ChromeOptions options = new ChromeOptions();
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		WebDriver driver = new FirefoxDriver();
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.cafci.org.ar/estadisticas.html");
		//switch to frame using index
		//driver.switchTo().frame(0);
		//switch to frame using id
		//driver.switchTo().frame("frame_contents");
		//switch to frame using element
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='info-diaria.html']")));
		
		
		Select select = new Select(driver.findElement(By.id("select")));
		select.selectByVisibleText("PyMes");
		driver.findElement(By.id("textfield1")).sendKeys("02/09/2020");
		WebElement submit_link = driver.findElement(By.linkText("Buscar"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(submit_link));
		//submit_link.click();
		

		
		Actions action = new Actions(driver);
		action.moveToElement(submit_link).build().perform();
		submit_link.click();

		 WebElement element = driver.findElement(By.id("errorDiv"));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.textToBePresentInElement(element, "No hay informacion para la fecha ingresada."));
		
		if (element.getText().equals("No hay informacion para la fecha ingresada."))
		{
			System.out.println("Test case is passed");
		} else {
			System.out.println("Test case is failed");
		}

	}

}
