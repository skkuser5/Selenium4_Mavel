package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PHP_Login {
	
	private WebDriver driver;
	By email_textbox= By.name("username");
	By password_textbox = By.name("password");
	By login_button = By.xpath("//button[text()='Login']");
	By Home_link = By.linkText("Home");
	
	public PHP_Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterEmailText(String userName) {
		driver.findElement(email_textbox).clear();
		driver.findElement(email_textbox).sendKeys(userName);
	}
	
	public void enterPasswordText(String password) {
		driver.findElement(password_textbox).clear();
		driver.findElement(password_textbox).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(login_button).click();
	}
	
	public void login(String userName, String password) {
		enterEmailText(userName);
		enterPasswordText(password);
		clickLoginButton();
		
	}
	
	public void clickHomePage() {
		driver.findElement(Home_link).click();
	}
	
	

}
