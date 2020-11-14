package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.io.*;

public class base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		
		//System.getProperty("user.dir") - gives the path of the project directory
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		//to get the browser from maven
		//mvn test -Dbrowser=chrome -- command to execute in chrome browser
		String browserName = System.getProperty("browser");
		
		//to get the browser from the data.properties file
		//String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				op.addArguments("headless");
			}
			
			driver = new ChromeDriver(op);
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			//IE driver code
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir"+"\\reports\\"+testCaseName+"\\.png");
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
		
//		String screenName = System.currentTimeMillis()+".png";
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		try
//		{
//			FileHandler.copy(src, new File(System.getProperty("user.dir")+"target/Screenshots/"+screenName+""));
//		}
//		catch(IOException e)
//		{
//			System.out.println(e.getMessage());
//		}
	}
}
