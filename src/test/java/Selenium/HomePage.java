package Selenium;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();	
	}
	
	//count to parameter should be equal to the count of values passed by the data provider method
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName, String password, String text) {	
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys(userName);
		login.getPassword().sendKeys(password);
		log.info(text);
		login.getLogin().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		//row stands for how many data types the test should run
		//column stands for how many values per test to be passed
		Object[][] data = new Object[2][3];
		data[0][0] = "qwerty@test.com";
		data[0][1] = "qwerty";
		data[0][2] = "1st user";
		
		data[1][0] = "asdf@test.com";
		data[1][1] = "asdf";
		data[1][2] = "2nd user";
		
		return data;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
