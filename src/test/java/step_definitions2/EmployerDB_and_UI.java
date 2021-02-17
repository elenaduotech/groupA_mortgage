package step_definitions2;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.*;
import pages.ApplicationListPage;
import pages.DPage;
import pages.MainPage;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;

public class EmployerDB_and_UI {

	@Given("The user Sign in")
	public void theUserSignIn() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		SignInPage sp = new SignInPage();
		sp.email.sendKeys(ConfigReader.getProperty("emailAddress"));
		sp.password.sendKeys(ConfigReader.getProperty("emailPassword"));
		sp.loginButton.click();
	}

	@When("The user click on the Application List and View Details")
	public void theUserClickOnTheApplicationListAndViewDetails() {
		new MainPage().applicationList.click();
		new ApplicationListPage().viewDetailsButton.click();
	}

	@Then("The employer information should match t database")
	public void theEmployerInformationShouldMatchTDatabase() {
		DPage dp = new DPage();
		String expectedEmployer = dp.employer.getText();

		String request = "select employer_name, position from tbl_mortagage where id='210'";
		List<Map<String, Object>> list = DBUtils.getQueryResultMap(request);
		Map<String, Object> map = list.get(0);

		String actualEmployer = (String) map.get("employer_name");

		assertTrue(actualEmployer.contains(expectedEmployer));
	}
}
