package qaAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;


public class HomePageTest extends base {
	
	public WebDriver driver;
	
	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}

	@Test
	public void basePageNavigation() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSE");
		log.info("Successfully validated Text message");
		driver.quit();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
