package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class LoginSteps extends base {
	
	@Given("^Initialize the browser$")
    public void initialize_the_browser() throws Throwable {
		driver = initializeDriver();
    }

	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
    	LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys(strArg1);
		login.getPassword().sendKeys(strArg2);
		login.getLogin().click();
    }

    @Then("^Verify that the user has logged in successfully$")
    public void verify_that_the_user_has_logged_in_successfully() throws Throwable {
        
    }

    @And("^Navigate to \"([^\"]*)\" website$")
    public void navigate_to_something_website(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @And("^Click on login link$")
    public void click_on_login_link() throws Throwable {
    	LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
    }
    
    @And("^Close the browser$")
    public void close_the_browser() throws Throwable {
        driver.quit();
    }
}
