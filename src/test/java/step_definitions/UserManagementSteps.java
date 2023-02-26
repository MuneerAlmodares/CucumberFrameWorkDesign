package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardElements;
import pages.CraterLogin;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class UserManagementSteps {
	BrowserUtils utils = new BrowserUtils();
	CraterLogin login = new CraterLogin();
	CraterDashboardElements dashbord = new CraterDashboardElements();
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
	    Driver.getDriver().get(DataReader.getData("craterUrl"));
	    Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    Thread.sleep(1000);
	    
	}
	@When("user enters VALID {string} AND {string}")
	public void user_enters_valid_and(String userEmail, String password) {
		login.login();
		
	}
	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
	   login.loginButton.click();
	    
	}
	
	@Then("user should be on the dashboard page")
	public void user_should_be_on_the_dashvoard_page() {
	  Assert.assertTrue(dashbord.amoutDueText.isDisplayed());
	}
	
	
	
	
	   // invalid login test
	@When("user enters invalid {string} and {string}")
	public void user_enters_invalid_and(String invalidUserEmail, String invalidUserPassword) {
	    utils.sendKeysWithActionsClass(login.Email, invalidUserEmail);
	    utils.sendKeysWithActionsClass(login.passowrd, invalidUserPassword);
	}
	@When("click login button")
	public void click_login_button() {
	   login.loginButton.click();
	}
	
	
	@Then("an error message appears")
	public void an_error_message_appears() {
	    utils.waitUntilElementVisible(login.invalidUserErrorMessage);
	    Assert.assertTrue(login.invalidUserErrorMessage.isDisplayed());
	}
	@Then("user is not logged in")
	public void user_is_not_logged_in() {
	   Assert.assertTrue(login.loginButton.isDisplayed());
	}
	@Then("user quits the browser")
	public void user_qi_uits_the_browser() {
	   Driver.quitDriver();
	   
	}
	
	// invalid login scenario outline 
	boolean emailfieldEmpty;
	boolean passwordFieldEmpty;
	
	@When("user enters invalid useremail {string} and password {string}")
	public void user_enters_invalid_useremail_and_password(String invaliduseremail, String invalidpassword) {
		emailfieldEmpty = invaliduseremail.isBlank();
		passwordFieldEmpty = invalidpassword.isBlank();
	    utils.sendKeysWithActionsClass(login.Email, invaliduseremail);
	    utils.sendKeysWithActionsClass(login.passowrd, invalidpassword);
	}
	@Then("error messages appear")
	public void error_messages_appear() {
	    if(emailfieldEmpty || passwordFieldEmpty) {
	    	utils.waitUntilElementVisible(login.FieldrequiredError);
	    	Assert.assertTrue(login.FieldrequiredError.isDisplayed());
	    }else {
	    	utils.waitUntilElementVisible(login.invalidUserErrorMessage);
	    	Assert.assertTrue(login.invalidUserErrorMessage.isDisplayed());
	    }
	}





}
