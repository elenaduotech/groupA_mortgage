package step_definitions2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;
import pages.DPage;
import pages.MainPage;
import pages.NPage;
import pages.SignInPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class EmploymentButtons {

	@Given("The user is on the Main Page and enters all necessary information")
	public void theUserIsOnTheMainPageAndEntersAllNecessaryInformation() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		SignInPage si = new SignInPage();
		si.email.sendKeys(ConfigReader.getProperty("email"));
		si.password.sendKeys(ConfigReader.getProperty("password"));
		si.loginButton.click();
		BrowserUtils.waitForPageToLoad(3);
		
		MainPage pm = new MainPage();
		pm.mortgageApplication.click();
		BrowserUtils.waitFor(3);
		
	}

	@Given("The user is on the Employment and Income page")
	public void theUserIsOnTheEmploymentAndIncomePage() {
		NPage np = new NPage();
		np.workWithRealtorNoBox.click();
		np.workWithLoanOfficerNoBox.click();
		np.estimatedPurchasePrice.sendKeys("500000");
		np.downpaymentAmount.sendKeys("20000");
		np.nextButton.click();
		BrowserUtils.waitForPageToLoad(3);
		
		BrowserUtils.jsClick(np.coborrowerNoBox);
		np.borrowerFirstName.sendKeys(ConfigReader.getProperty("name"));
		np.borrowerLastName.sendKeys(ConfigReader.getProperty("last_name"));
		np.borrowerEmail.sendKeys(ConfigReader.getProperty("email"));
		np.borrowerDob.sendKeys("01/01/1985");
		np.borrowerSsn.sendKeys(ConfigReader.getProperty("ssn"));
		np.maritalStatusDropdownBox.click();
		np.inputBox.sendKeys("Married" + Keys.ENTER);
		np.borrowerCellPhoneNo.sendKeys("222-22-2222");
		np.nextButton.click();
		
		np.monthlyPaymentField.sendKeys("800");
		np.nextButton.click();
	}

	@When("The user click on the Clear button")
	public void theUserClickOnTheButton() {
		BrowserUtils.waitForPageToLoad(3);
	    DPage dp = new DPage();
	    BrowserUtils.jsClick(dp.clearButton);
	}

	@Then("The message popUp should appear")
	public void theMessagePopUpShouldAppear() {
	    DPage dp = new DPage();
	    assertTrue(BrowserUtils.elementExists(dp.popupClearDialogWindow, 2));
	}

	@Then("The message should display {string}")
	public void theMessageShouldDisplay(String expectedHeader) {
	    DPage dp = new DPage();
	    String actualHeader = dp.popupHeader.getText();
	    assertEquals(expectedHeader, actualHeader);
	}

	@Then("The user should be able to pick Cancel button")
	public void theUserShouldBeAbleToPickCancelButton() {
		DPage dp = new DPage();
		BrowserUtils.popUpHandle(dp.cancelButtonPop);
	}

	@When("The user enters employer information")
	public void theUserAllEmployerInformation() {
		DPage dp = new DPage();
		dp.employerName.sendKeys(ConfigReader.getProperty("employer"));
		dp.position.sendKeys(ConfigReader.getProperty("position"));
		dp.city.sendKeys(ConfigReader.getProperty("city"));
		Select s = new Select(dp.state);
		s.selectByValue("AK");
		dp.startDate.sendKeys("01/01/2005");
		}
	
	@Then("The user clicks on the Clear Button")
	public void theUSerClicksOnTheClearButton(){
		BrowserUtils.waitForPageToLoad(2);
		DPage dp = new DPage();
		BrowserUtils.jsClick(dp.clearButton);
	}
	
	@Then("The user clicks on Yes to clear all employer information")
	public void theUserclicksOnYesToClearAllEmployerInformation() {
		DPage dp = new DPage();
		BrowserUtils.popUpHandle(dp.yesButtonPop);
	}
	@Then("The users information should be cleared")
	public void theUsersInformationShouldBeClear() {
		DPage dp = new DPage();
		assertEquals(dp.employerName.getText(),"");
		assertEquals(dp.position.getText(),"");
	}


	@When("The user should be able to click on the Add Another Employer button")
	public void theUserShouldBeAbleToLickOnTheButton() {
	    DPage dp = new DPage();
	    dp.addEmployer.click();
	}

	@Then("The user should be able to see the Employer2")
	public void theUserShouldBeAbleToSeeTheWindow() {
		DPage dp = new DPage();
	    assertTrue(BrowserUtils.elementExists(dp.employer2, 2));
	}

	@When("The user click on the Add Another Employer")
	public void theUserClickOnThe() {
	    DPage dp = new DPage();
	    dp.addEmployer.click();
	}

	@Then("The user should be able to click on the Remove button")
	public void theUserShouldBeAbleToClickOnTheButton() {
	    DPage dp = new DPage();
	    dp.remove.click();
	}

	@Then("The popUp message should appier with a message {string}")
	public void thePopUpMessageShouldAppierWithAMessage(String expectedHeadersPop) {
	    DPage dp = new DPage();
	    String actualHeaderPpop = dp.popupHeader2.getText();
	    assertEquals(expectedHeadersPop,actualHeaderPpop);
	}

	@Then("The user should be able to click Yes")
	public void theUserShouldBeAbleToClickYes() {
	    DPage dp = new DPage();
	    dp.yesButtonPop.click();
	}
}
