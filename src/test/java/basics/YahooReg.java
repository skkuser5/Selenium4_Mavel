package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class YahooReg {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Aug2020\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("createacc")).click();
		//WebElement firstname_textBox=driver.findElement(By.id("usernamereg-firstName"));
		//WebElement firstname_textBox= driver.findElement(By.className("ureg-fname"));
		//WebElement firstname_textBox= driver.findElement(By.cssSelector("#usernamereg-firstName"));
		//firstname_textBox.click();
		//firstname_textBox.clear();
		//firstname_textBox.sendKeys("Robert");
		
		//driver.findElement(By.xpath("//a[text()='Terms ']")).click();
		
		String headerText=driver.findElement(By.xpath("//*[@id=\"account-attributes-challenge\"]/h1")).getText();
		System.out.println(headerText);
		
		
		WebElement select_drop_elm= driver.findElement(By.name("shortCountryCode"));
		Select sel_drop= new Select(select_drop_elm);
		// using index
		
		//sel_drop.selectByIndex(0);
		//sel_drop.selectByVisibleText("India ‪(+91)‬");
		sel_drop.selectByValue("CA");

	}

}
