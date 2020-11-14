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

public class ValidateNavigationBar extends base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));	
	}
	
	@Test
	public void basePageNavigation() {		
		LandingPage lp = new LandingPage(driver);		
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Successfully validated the Navigation bar");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
