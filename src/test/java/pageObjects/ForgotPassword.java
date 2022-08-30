package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver driver;
	
	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}
	
	By Email = By.id("user_email");
	
	By sendMeInstruction = By.name("commit");
	

	public WebElement getEmail() {
		return driver.findElement(Email);
	}
	public WebElement sendMeInstructionBtn() {
		return driver.findElement(sendMeInstruction);
	}

}
