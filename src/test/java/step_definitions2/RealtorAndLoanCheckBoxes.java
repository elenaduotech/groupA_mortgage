package step_definitions2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;
import pages.MainPage;
import pages.MortgageApplicationPage;
import pages.NPage;
import pages.SignInPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class RealtorAndLoanCheckBoxes {

	@Given("The user in on the Main Page")
	public void theUserInOnTheMainPage() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		SignInPage si = new SignInPage();
		si.email.sendKeys(ConfigReader.getProperty("email"));
		si.password.sendKeys(ConfigReader.getProperty("password"));
		si.loginButton.click();
		BrowserUtils.waitForPageToLoad(3);
	}

	@When("The user click on the Mortgage Application")
	public void theUserClickOnTheMortgageApplication() {
		MainPage pm = new MainPage();
		pm.mortgageApplication.click();
		BrowserUtils.waitFor(4);
	}

	@When("The user chooses no for question")
	public void theUserChoosesNoForQuestion() {
		NPage np = new NPage();
		np.workWithRealtorNoBox.click();
		assertEquals("No", np.workWithRealtorNoBox.getText());
	}

	@Then("The user should not be able to put any information in Realtor Information Box")
	public void theUserShouldNotBeAbleToPutAnyInformationInRealtorInformationBox() {
		NPage np = new NPage();
		try {
			np.realtorInfo.sendKeys("John Smith");
		} catch (Exception e) {
		}
		String realtorBoxText = np.realtorInfo.getText();
		assertEquals("", realtorBoxText);
	}

	@When("The user chooses yes for question")
	public void theUserChoosesYesForQuestion() {
		NPage np = new NPage();
		MainPage pm = new MainPage();
		BrowserUtils.waitForPageToLoad(5);
		pm.mortgageApplication.click();
		BrowserUtils.waitFor(2);
		np.workWithRealtorYesBox.click();
		assertEquals("Yes", np.workWithRealtorYesBox.getText());
	}

	@Then("The user should be able to put in info of the realtor")
	public void theUserShouldBeAbleToPutInInfoOfTheRealtor() {
		NPage np = new NPage();
		np.realtorInfo.sendKeys("John Anderson");
		BrowserUtils.waitFor(3);
	}

	@When("The user chooses no for loan officer")
	public void theUserChoosesNoForLoanOfficer() {
		MainPage pm = new MainPage();
		pm.mortgageApplication.click();
		BrowserUtils.waitFor(4);
		NPage np = new NPage();
		np.workWithLoanOfficerNoBox.click();
	}

	@Then("The user should see check mark next to no option")
	public void theUserShouldSeeCheckMarkNextToNoOption() {
		NPage np = new NPage();
		String boxText = np.workWithLoanOfficerNoBox.getText();
		assertEquals(boxText, "No");
	}

	@When("The user click on yes")
	public void theUserClickOnYes() {
		NPage np = new NPage();
		np.workWithLoanOfficerYesBox.click();
	}

	@Then("The user should be able to see check mark next to yes option")
	public void theUserShouldBeAbleToSeeCheckMarkNextToYesOption() {
		NPage np = new NPage();
		String boxText = np.workWithLoanOfficerYesBox.getText();
		assertEquals(boxText, "Yes");
	}

}
