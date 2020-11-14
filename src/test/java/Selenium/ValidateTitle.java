package Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	
	@Test
	public void basePageNavigation() {
		LandingPage lp = new LandingPage(driver);
		String actualPageTitle = lp.getTitle().getText();
		String expectedPageTitle = "FEATURED CO123URSES";
		
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		log.info("Successfully validated the title");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
