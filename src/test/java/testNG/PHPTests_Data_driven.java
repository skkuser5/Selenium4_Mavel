package testNG;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.ExcelXUtil;

public class PHPTests_Data_driven {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
//beforeTest
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://phptravels.net/login");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("Login"));
		
	}
	
	@Test(priority = 0,groups = {"sanity"})
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "Login","verify Title");		
		
	}
	
	@Test(priority=1,groups = {"sanity","regression"})
	public void verifyButtons() {
		Assert.assertEquals(driver.findElement(By.xpath("//button[text()='Login']")).isDisplayed(), true,"verify Login button");	
		//Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Login']")).isDisplayed(), "verify Login button");
		Assert.assertEquals(driver.findElement(By.xpath("//form[@id='loginfrm']//a[contains(text(),'Sign Up')]")).isDisplayed(), true,"verify Signup link");	
		Assert.assertEquals(driver.findElement(By.xpath("//form[@id='loginfrm']//a[contains(text(),'Forget Password')]")).isDisplayed(), true,"verify forget password link");	
		
	}
	
//	@Test(priority=2,groups = {"regression"},dataProvider ="loginTest" )
//	public void verifyInvalidEmailMsg(String userName, String password) {
//		driver.findElement(By.name("username")).clear();
//		driver.findElement(By.name("username")).sendKeys(userName);
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.xpath("//button[text()='Login']")).click();
//		
//		By element = By.xpath("//div[contains(@class,'alert')]");
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.presenceOfElementLocated(element));
//		String text = driver.findElement(element).getText();
//		
//		Assert.assertEquals(text, "Invalid Email or Password","verify invalid email msg");
//	}
	
	
	@Test(priority=2,groups = {"regression"},dataProvider ="ExcelRead" )
	public void verifyInvalidEmailMsg(String userName, String password) {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		By element = By.xpath("//div[contains(@class,'alert')]");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		String text = driver.findElement(element).getText();
		
		Assert.assertEquals(text, "Invalid Email or Password","verify invalid email msg");
	}
	
	@DataProvider(name="loginTest")
	public Object[][] dataProvider(){
		
		Object[][] array = new Object[][] {{"test@gmail.com","test1234"},{"","test11"},{"test2@gmail.com",""}};
		
		return array;
		
		
	}
	
	@DataProvider(name="ExcelRead")
	public String[][] excelDataProvider(){
		String[][] temp= null;
		String projPath = System.getProperty("user.dir");
		String xlsFilePath = projPath+"\\src\\test\\resources\\testData\\UsersData.xlsx";
		ExcelXUtil excel = new ExcelXUtil(xlsFilePath);
		
		int rowCount=excel.getRowCount("Sheet1");
		int colCount = excel.getColumnCount("Sheet1", 1);
		temp= new String[rowCount-1][colCount];
		int k=0;
		for(int i=1;i<rowCount;i++)
		{
			for (int j=0;j<colCount;j++)
			{
				temp[k][j] = excel.getCellValue("Sheet1", i, j);
			}
			k++;
		}
		
		
		
		
		return temp;
	}
	
	@Test(priority=3,groups = {"regression"},dependsOnGroups = {"sanity"})
	public void verifyValidEmailMsg() {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("demouser");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("My Account"));
		
		
		Assert.assertEquals(driver.getTitle(), "My Account","verify successful login");
	}
	
	@Test(dependsOnMethods = "verifyValidEmailMsg",groups = {"regression"})
	public void verifyLinksAfterLogin() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).isDisplayed(),"verify My profile link");
		
	}
	
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	
	

	
}
