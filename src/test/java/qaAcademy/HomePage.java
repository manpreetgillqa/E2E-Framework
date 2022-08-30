package qaAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.base;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;


public class HomePage extends base {
	
	public WebDriver driver;
	
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialzed");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username , String password , String text) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		LandingPage lp = new LandingPage(driver);
		LoginPage l=lp.getLogin();
		l.getEmail().sendKeys(username);
		l.getpassword().sendKeys(password);
		log.info(text);
		l.getLogin().click();
		ForgotPassword fp = l.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructionBtn().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object [][] data = new Object [2][3];
		
		//Row stands for how many different data types the test should run
		
		//column stands for how many values for each test
		
		// O Row
		
		data[0][0] = "nonrestricteduser@abc.com";
		data[0][1] = "12345";
		data[0][2] = "Restricted User";
		
		// 1 Row
		
		data[1][0] = "restricteduser@abc.com";
		data[1][1] = "12345";
		data[1][2] = "Non-Restricted User";
		
		return data;
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
