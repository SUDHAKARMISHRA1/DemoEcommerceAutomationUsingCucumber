package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.HomePageModel;
import models.LoginModel;
import pageObjects.HomePage;
import testComponents.BaseTest;
import testComponents.FetchTestDataFromExcelSheet;

public class LoginPageValidations extends BaseTest {

	public HomePage loginpage;
	
	public String sheetname = "LoginPage";

	HomePageModel HPM = new HomePageModel();
	LoginModel UL = new LoginModel();
	FetchTestDataFromExcelSheet fData = new FetchTestDataFromExcelSheet();
	
	@When("User click on Login button")
	public void user_click_on_login_button() throws IOException {
		System.out.println("Log1");
		//loginpage = launchApplication();
	}
	
	@Given("User will be on Login Screen")
	public void user_will_be_on_login_screen() {
		System.out.println("Log2");
	}
	
	@When("User Enter the username")
	public void user_enter_the_username() {
	   
	}
	
	@When("User Enter the password")
	public void user_enter_the_password() {
	   
	}
	
	@When("User click on Submit button")
	public void user_click_on_submit_button() {
	    
	}
	
	@Then("User should login successfully")
	public void user_should_login_successfully() {
	    
	}
	
}
