package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;
import pages.TestBase;

public class TechfiosStepDefinition extends TestBase {

	@Before
	public void beforeRun() {
		initDriver();
		loginpage = PageFactory.initElements(driver, LoginPage.class);

	}

	LoginPage loginpage;

	@Given("^User is on techfios login page$")
	public void user_is_on_techfios_login_page() {
		driver.get("https://techfios.com/billing/?ng=login/");

	}
	
	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String username)  {
	    


	}
	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) {
		
	    loginpage.enterPassword(password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@When("^User clicks on signin button$")
	public void user_clicks_on_signin_button()throws Throwable {
		loginpage.clickSignInButton();

	}

	@Then("^User should land on dashboard page$")
	public void user_should_land_on_dashboard_page(){
		Assert.assertEquals("Dashboard - iBilling", loginpage.getPageTitle());
		takeScreenshot(driver);
	}

	@Then("^User should not land on dashboard page$")
	public void user_should_not_land_on_dashboard_page() throws Throwable {
		Assert.assertEquals("Dashboard- iBilling", loginpage.getPageTitle());
	}
		
	@When("^User enters \"([^\"]*)\" from techfios database$")
	public void user_enters_from_techfios_database(String loginData)throws Throwable{

	 

		switch (loginData) {
		case "username":
			break;

		case "password":
			break;

		default:
			System.out.println("Unable to enter login data from DB!");
		}
	}
	
	@After
	public void tearDown() {
	
		driver.close();
		driver.quit();
	}
}


