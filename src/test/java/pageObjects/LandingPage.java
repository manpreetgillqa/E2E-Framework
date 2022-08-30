package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signIn = By.linkText("Login");
	By title = By.xpath("(//*[@class='text-center'])[1]");
	By navBar = By.xpath("//*[@class='nav navbar-nav navbar-right']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {
	driver.findElement(signIn).click();
	return new LoginPage(driver);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}
	
}
