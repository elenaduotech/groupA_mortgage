package step_definitions2;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.*;
import pages.MainPage;
import pages.MortgageApplicationPage;
import pages.NPage;
import pages.SignInPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class PurposeOfLoan {
	
	@Given("The user in on Main Page")
	public void theUserInOnMainPage() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		SignInPage si = new SignInPage();
		si.email.sendKeys(ConfigReader.getProperty("email"));
		si.password.sendKeys(ConfigReader.getProperty("password"));
		si.loginButton.click();
		BrowserUtils.waitForPageToLoad(3);
	}

	@Given("The user clicks on the Mortgage Application")
	public void theUserClicksOnTheMortgageApplication() {
		MainPage pm = new MainPage();
		pm.mortgageApplication.click();
		BrowserUtils.waitFor(4);
	}

	@When("The user clicks on the purpose of the loan and enters the {string}")
	public void theUserClicksOnThePurposeOfTheLoanAndEntersThe(String purpose) {
	    NPage np = new NPage();
	    np.purposeOfLoanDropdownBox.click();
	    np.inputPurposeBox.sendKeys(purpose);
	}

	@Then("The system should not recognize the entrees and display the {string}")
	public void theSystemShouldNotRecognizeTheEntreesAndDisplayThe(String expectedMessage) {
		NPage np = new NPage();
		String actualMessage = np.purposeResultMessage.getText();
		assertEquals(expectedMessage, actualMessage);
	}

}
