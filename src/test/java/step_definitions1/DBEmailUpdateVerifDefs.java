package step_definitions1;

import static org.junit.Assert.assertEquals;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignInPage;
import utilities.DBUtils;

public class DBEmailUpdateVerifDefs {
	
	String updatedEmail;
    String id;
    
	@When("I update user email with {string} for a user with id {string}")
	public void iUpdateUserEmailWithForAUserWithId(String updatedEmail, String id) {
	  String myQuery = "update tbl_user set email='" + updatedEmail + "' where id='" + id +"'";
	  this.updatedEmail = updatedEmail;
	  this.id = id;
	  DBUtils.updateQuery(myQuery);
	}


	@Then("Check if user can login using updated email info and see user's name {string}")
	public void checkIfUserCanLoginUsingUpdatedEmailInfoAndSeeUserSName(String expectedName) {
		 SignInPage sp = new SignInPage();
			

			
			sp.email.sendKeys(updatedEmail);
			sp.password.sendKeys("12345s");
			sp.loginButton.click();
			
			String actualName = sp.userNameVerification.getText();
			assertEquals("Correct Name", expectedName, actualName);
			
			
			//update the email to be able to repeat the test again
	     
			String old_updatedEmail = "sophiayen@mc.com";
			String query = "update tbl_user set email='" + old_updatedEmail  + "' where id='" + id +"'";
	        DBUtils.updateQuery(query);
	}
}
