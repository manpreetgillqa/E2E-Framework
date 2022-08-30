package qaAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class validateNavigationBar extends base {
	
	public WebDriver driver;
	
	private static Logger log = LogManager.getLogger(validateNavigationBar.class.getName());
	
	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is Present");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
