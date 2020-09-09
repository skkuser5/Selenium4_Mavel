package intermediate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.javafx.tk.Toolkit;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.input.Clipboard;

public class FileUpload {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://fineuploader.com/demos.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.manage().window().minimize();
		
		Thread.sleep(5000);
		
		driver.manage().window().fullscreen();
		
		
		WebElement fileUpload = driver.findElement(By.name("qqfile"));
		//fileUpload.sendKeys("C:\\Training\\Aug2020\\test.png");
		
		
		
		
		fileUpload.click();
		
		StringSelection filePath= new StringSelection("C:\\Training\\Aug2020\\test.png");
		
		java.awt.datatransfer.Clipboard clip = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
		clip.setContents(filePath, null);
		
		Robot robot = new Robot();
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
