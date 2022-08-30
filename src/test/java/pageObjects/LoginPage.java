package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Email = By.id("user_email");
	
	By Password = By.id("user_password");
	
	By loginBtn = By.name("commit");
	
	By forgotPassword = By.linkText("Forgot Password?");
	
	
	
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return  new ForgotPassword(driver);			
	}

	public WebElement getEmail() {
		return driver.findElement(Email);
	}
	public WebElement getpassword() {
		return driver.findElement(Password);
	}
	public WebElement getLogin() {
		return driver.findElement(loginBtn);
	}
	
	
	
}
