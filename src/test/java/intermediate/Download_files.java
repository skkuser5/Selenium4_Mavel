package intermediate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Download_files {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stubhttps://www.sample-videos.com/download-sample-xls.php
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.sample-videos.com/download-sample-xls.php");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='download_xls'][contains(@href,'100-rows.xls')]")).click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.delay(500);
		
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		

	}

}
