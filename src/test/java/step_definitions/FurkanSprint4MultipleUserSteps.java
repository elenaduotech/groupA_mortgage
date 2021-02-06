package step_definitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApplicationListPage;
import pages.MainPage;
import pages.MortgageApplicationPage;
import pages.ViewDetailsPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class FurkanSprint4MultipleUserSteps {
	
	@Given("The user enters following information in custom type {string},{string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void theUserEntersFollowingInformationInCustomType(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
	  
		 MainPage mp = new MainPage();
		    mp.mortgageApplication.click();
		    BrowserUtils.waitFor(3);
		    MortgageApplicationPage ma = new MortgageApplicationPage();
		    ma.workWithRealtorNoBox.click();
		    ma.workWithLoanOfficerNoBox.click();
		    ma.estimatedPurchasePrice.sendKeys("300000");
		    ma.downpaymentPercentage.click();
		    ma.downpaymentPercentage.sendKeys(Keys.BACK_SPACE);
		    ma.downpaymentPercentage.sendKeys("10");
		    BrowserUtils.waitFor(3);
		    ma.nextButton.click();
		    
		    
		    BrowserUtils.waitForClickablility(ma.coborrowerNoBox, 3);
		    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		    js.executeScript("arguments[0].click();", ma.coborrowerNoBox);
		    ma.borrowerFirstName.sendKeys(string);
		    ma.borrowerLastName.sendKeys(string2);
		    ma.borrowerEmail.sendKeys(string6);
		    ma.borrowerDob.sendKeys(string4);
		    ma.borrowerSsn.sendKeys(string3,Keys.TAB,Keys.ENTER,Keys.ARROW_DOWN,Keys.ENTER);
		    ma.borrowerCellPhoneNo.sendKeys(string5);
		    BrowserUtils.waitForClickablility(ma.privacyPolicyBox, 3);
		    if(!ma.privacyPolicyBox.isSelected()) {
		    js.executeScript("arguments[0].click();", ma.privacyPolicyBox);}
		    BrowserUtils.waitFor(3);
		    ma.nextButton.click();
		    
		    
		    
		    BrowserUtils.waitForClickablility(ma.ownBox, 3);
		    if(!ma.rentBox.isSelected()) {
		    	js.executeScript("arguments[0].click();", ma.rentBox);}
		    ma.monthlyPaymentField.sendKeys("500");
		    BrowserUtils.waitFor(3);
		    ma.nextButton.click();
		    
		    
		    
		    BrowserUtils.waitForClickablility(ma.grossMonthlyIncome, 3);
		    ma.grossMonthlyIncome.sendKeys(string7);
		    ma.employerName.sendKeys("N/A");
		    BrowserUtils.waitFor(3);
		    ma.nextButton.click();
		    
		    
		    
		    
		    BrowserUtils.waitForClickablility(ma.preapprovalInquiryNoBox, 3);
		    if(!ma.preapprovalInquiryYesBox.isSelected()) {
		    	js.executeScript("arguments[0].click();", ma.preapprovalInquiryYesBox);}
		    BrowserUtils.waitFor(3);
		    ma.nextButton.click();
		    
		    
		    
		    
		    BrowserUtils.waitForClickablility(ma.eConsentdeclarerFirstName, 3);
		    ma.eConsentdeclarerFirstName.sendKeys(string);
		    ma.eConsentdeclarerLastName.sendKeys(string2);
		    ma.eConsentdeclarerEmail.sendKeys(string6);
		    js.executeScript("arguments[0].click();", ma.agreeBox);
		    BrowserUtils.waitFor(3);
		    ma.nextButton.click();
		    
		    
		    
		    
		    
		    BrowserUtils.waitForClickablility(ma.saveButton, 3);
		    ma.saveButton.click();
		    BrowserUtils.waitFor(3);
		       
		}	
		
		
		
	

	@Then("The user should see that the {string} information is right")
	public void theUserShouldSeeThatTheInformationIsRight(String string) {
		
		ApplicationListPage al = new ApplicationListPage();
		al.viewDetailsButton.click();
		BrowserUtils.waitFor(3);
		ViewDetailsPage vd = new ViewDetailsPage();
		
		assertEquals(vd.ssn.getText(),string);
	}

}
