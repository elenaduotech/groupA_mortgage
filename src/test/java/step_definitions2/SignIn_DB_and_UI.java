package step_definitions2;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.MainPage;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;

public class SignIn_DB_and_UI {

	@Given("The user is on the sign-in page enter correct credentials")
	public void theUserIsOnTheSignInPageEnterCorrectCredentials() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		SignInPage sp = new SignInPage();
		sp.email.sendKeys(ConfigReader.getProperty("emailAddress"));
		sp.password.sendKeys(ConfigReader.getProperty("emailPassword"));
		sp.loginButton.click();

	}

	@Then("The users name should be displayed as a user")
	public void theUsersNameShouldBeDisplayedAsAUser() {
		MainPage mp = new MainPage();
		String actualUser = mp.userName.getText();
		String expectedUser = ConfigReader.getProperty("firstName") + " " + ConfigReader.getProperty("lastName");
		assertEquals(expectedUser, actualUser);
	}

	@Then("User details should be mapped correctly in the database")
	public void UserDetailsShouldBeMappedCorrectly() {

		String request = "select first_name, last_name, email from tbl_user where id='2366'";

		List<Map<String, Object>> list = DBUtils.getQueryResultMap(request);
		Map<String, Object> map = list.get(0);
		String actualFirst = (String) map.get("first_name");
		String actualLast = (String) map.get("last_name");
		String actualEmail = (String) map.get("email");

		String expectedFirst = ConfigReader.getProperty("firstName");
		String expectedLast = ConfigReader.getProperty("lastName");
		String expectedEmail = ConfigReader.getProperty("emailAddress");

		assertEquals(expectedFirst, actualFirst);
		assertEquals(expectedLast, actualLast);
		assertEquals(expectedEmail, actualEmail);
	}

}
