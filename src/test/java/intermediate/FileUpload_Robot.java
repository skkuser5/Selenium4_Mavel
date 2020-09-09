package intermediate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.javafx.tk.Toolkit;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.input.Clipboard;

public class FileUpload_Robot {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://dhtmlx.com/docs/products/dhtmlxVault/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement fileUpload = driver.findElement(By.xpath("//*[@id=\"vault\"]/div/div/div[1]/div/div/div[@dhx_id='add']/div"));
		
		
		
		
		
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
