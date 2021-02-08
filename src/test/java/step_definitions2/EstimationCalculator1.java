package step_definitions2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import io.cucumber.java.en.*;
import pages.MortgageApplicationPage;
import pages.NPage;
import utilities.BrowserUtils;

public class EstimationCalculator1 {
	
	@When("The user enters {string} for estimated purchase")
	public void theUserEntersForEstimatedPurchase(String amount) {
	    NPage np = new NPage();
	    BrowserUtils.jsClick(np.estimatedPurchasePrice);
		np.estimatedPurchasePrice.sendKeys(amount);
	}

	@When("The user enters {string}")
	public void theUserEnters(String downPayment) {
		NPage np = new NPage();
		BrowserUtils.jsClick(np.downpaymentAmount);
		np.downpaymentAmount.sendKeys(downPayment);
	}

	@Then("The message should display the {string}")
	public void theMessageShouldDisplayThe(String expLoan) {
		NPage np = new NPage();
		String actualLoan = np.loanAmount.getText();
		assertEquals(expLoan, actualLoan);
	}

	@When("The user clicks on the drop down menu for  the source of payment")
	public void theUserClicksOnTheDropDownMenuForTheSourceOfPayment() {
		NPage np = new NPage();
		BrowserUtils.scroll(0, 500);
		BrowserUtils.jsClick(np.sourceOfDownpaymentDropdownBox);
		
	}

	@Then("The user should see following options")
	public void theUserShouldSeeFollowingOptions(List<String> expResult) {
		NPage np = new NPage();
		np.sourceOfDownpaymentDropdownBox.click();
		BrowserUtils.waitFor(3);
	    List<String> actualResult = BrowserUtils.getElementsText(np.downPaymentOptions);
	    assertEquals(expResult, actualResult);
	}

	@Then("The user clicks Next")
	public void theUserClicksNext() {
	    NPage np = new NPage();
	    np.nextButton.click();
	}
}
