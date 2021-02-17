package step_definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApplicationListPage;
import pages.MainPage;
import pages.MortgageApplicationPage;
import pages.SignInPage;
import pages.ViewDetailsPage;
import pojos.User;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;
import utilities.ExcelUtils;

public class FurkanSprint5DatabaseVerifySteps {
	
	private String ssn;
	private String dob;
	
	@Given("The User is on the homepage")
	public void theUserIsOnTheHomepage() {
	    Driver.getDriver().get(ConfigReader.getProperty("url"));
	    
	}

	@When("The user enters correct credentials and click on login")
	public void theUserEntersCorrectCredentialsAndClickOnLogin() {
		SignInPage si = new SignInPage();
		si.email.sendKeys(ConfigReader.getProperty("email"));
		si.password.sendKeys(ConfigReader.getProperty("password"));
		si.loginButton.click();
		BrowserUtils.waitForPageToLoad(3);
		
	}

	@Given("The user enters following information to the mortgage application")
	public void theUserEntersFollowingInformationToTheMortgageApplication(List<User> dataTable) {
		ExcelUtils excel = new ExcelUtils("testData.xlsx","Sheet1");
		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
	    User user = dataTable.get(0);
	    ssn=user.getSsn();
	    dob=user.getDateOfBirth();
	    MainPage mp = new MainPage();
	    mp.mortgageApplication.click();
	    BrowserUtils.waitFor(3);
	    MortgageApplicationPage ma = new MortgageApplicationPage();
	    BrowserUtils.waitForClickablility(ma.workWithRealtorNoBox, 3);
	    js.executeScript("arguments[0].click();", ma.workWithRealtorNoBox);
	    BrowserUtils.waitForClickablility(ma.workWithLoanOfficerNoBox, 3);
	    js.executeScript("arguments[0].click();", ma.workWithLoanOfficerNoBox);
	    ma.estimatedPurchasePrice.sendKeys(excel.getCellData(1, 0));
	    ma.downpaymentPercentage.click();
	    ma.downpaymentPercentage.sendKeys(Keys.BACK_SPACE);
	    ma.downpaymentPercentage.sendKeys("10");
	    BrowserUtils.waitFor(3);
	    ma.nextButton.click();
	    
	    
	    BrowserUtils.waitForClickablility(ma.coborrowerNoBox, 3);
	    js.executeScript("arguments[0].click();", ma.coborrowerNoBox);
	    ma.borrowerFirstName.sendKeys(user.getFirstName());
	    ma.borrowerLastName.sendKeys(user.getLastName());
	    ma.borrowerEmail.sendKeys(user.getEmail());
	    ma.borrowerDob.sendKeys(user.getDateOfBirth());
	    ma.borrowerSsn.sendKeys(user.getSsn(),Keys.TAB,Keys.ENTER,Keys.ARROW_DOWN,Keys.ENTER);
	    ma.borrowerCellPhoneNo.sendKeys(user.getCellPhoneNumber());
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
	    ma.grossMonthlyIncome.sendKeys("10000");
	    ma.employerName.sendKeys("N/A");
	    BrowserUtils.waitFor(3);
	    ma.nextButton.click();
	    
	    
	    
	    
	    BrowserUtils.waitForClickablility(ma.preapprovalInquiryNoBox, 3);
	    if(!ma.preapprovalInquiryYesBox.isSelected()) {
	    	js.executeScript("arguments[0].click();", ma.preapprovalInquiryYesBox);}
	    BrowserUtils.waitFor(3);
	    ma.nextButton.click();
	    
	    
	    
	    
	    BrowserUtils.waitForClickablility(ma.eConsentdeclarerFirstName, 3);
	    ma.eConsentdeclarerFirstName.sendKeys(user.getFirstName());
	    ma.eConsentdeclarerLastName.sendKeys(user.getLastName());
	    ma.eConsentdeclarerEmail.sendKeys(user.getEmail());
	    js.executeScript("arguments[0].click();", ma.agreeBox);
	    BrowserUtils.waitFor(3);
	    ma.nextButton.click();
	    
	    
	    
	    
	    
	    BrowserUtils.waitForClickablility(ma.saveButton, 3);
	    ma.saveButton.click();
	    BrowserUtils.waitFor(3);
	       
	}

	@When("The user clicks on application list")
	public void theUserClicksOnApplicationList() {
		MainPage mp = new MainPage();
		mp.applicationList.click();
		BrowserUtils.waitFor(3);
	}

	@Then("The user should see that the ssn dob information is right")
	public void theUserShouldSeeThatTheNameSsnDobInformationIsRight() {
		
		ApplicationListPage al = new ApplicationListPage();
		al.viewDetailsButton.click();
		BrowserUtils.waitFor(3);
		ViewDetailsPage vd = new ViewDetailsPage();

		System.out.println(vd.ssn.getText());
		System.out.println(vd.dateOfBirth.getText());
		
		assertEquals(vd.ssn.getText(),ConfigReader.getProperty("ssn"));
		assertEquals(vd.dateOfBirth.getText(),ConfigReader.getProperty("dob"));
		
	
	}
	
	@Then("same information needs to be verified in db")
	public void sameInformationNeedsToBeVerifiedInDb() {
	    
		
		String query="select b_ssn , b_dob from tbl_mortagage where b_email='jbiden@gmail.com'";
		
		List<Map<String,Object>>list=new ArrayList<>();
		list=DBUtils.getQueryResultMap(query);
		Map<String,Object>map=new HashMap<>();
		map=list.get(0);
		String expectedSsn=(String)map.get("b_ssn");
		String expectedDob=(String)map.get("b_dob");
		System.out.println(expectedSsn + " " + expectedDob);
		System.out.println(ssn + " " + dob);
		
		assertEquals(expectedSsn,ssn);
		assertEquals(expectedDob,ConfigReader.getProperty("dob"));
		
		
		
		
		
		
	}

}
