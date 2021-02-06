package step_definitions3;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;


public class SignInStepDefs {
	@Given("The user is on homepage")
	public void theUserIsOnHomepage() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
	}

	@When("The user enter correct email and password and clicks Login")
	public void theUserEnterCorrectEmailAndPasswordAndClicksLogin() {
	  SignInPage sp = new SignInPage();
	  
	  sp.email.sendKeys("sophiayen@mc.com");
	  sp.password.sendKeys("12345s");
	  sp.loginButton.click();
	  
		
	}

	@Then("The user should see his name")
	public void theUserShouldSeeHisName() {
		 SignInPage sp = new SignInPage();
		
	  String actualName = sp.userNameVerification.getText();
	  String expectedName = "Sophia Yen";

	  assertEquals(expectedName, actualName);
	  
	}

	
	@When("The user enters {string} and {string} and clicks Login")
	public void theUserEntersAndAndClicksLogin(String string, String string2) {
		 SignInPage sp = new SignInPage();
		  
		  sp.email.sendKeys(string);
		  sp.password.sendKeys(string2);
		  sp.loginButton.click();
		
		
		
	}

	@Then("The user should not login and the error message should appear")
	public void theUserShouldNotLoginAndTheErrorMessageShouldAppear() {
		 SignInPage sp = new SignInPage();
		String loginFailedMessage = sp.loginFailedMessage.getText().substring(34);
		String expectedLoginFailedMessage = "Login Failed";
	
		assertEquals(expectedLoginFailedMessage , loginFailedMessage);
		
	}
	
	@When("The user clicks on picture image and presses Log out")
	public void theUserClicksOnPictureImageAndPressesLogOut() {
		 SignInPage sp = new SignInPage();
		 sp.logOut.click();
		 sp.logOutButton.click();
		 
		 
	}

	@Then("The user should log out and land on homepage with Welcome Back, Automation Testers! message")
	public void theUserShouldLogOutAndLandOnHomepageWithWelcomeBackAutomationTestersMessage() {
		 SignInPage sp = new SignInPage();
		String actualText = sp.loginFailedMessage.getText().substring(0, 33);
	
		String expectedText = "Welcome Back, Automation Testers!";
		assertEquals(expectedText , actualText);
		
	}
	
	
}
