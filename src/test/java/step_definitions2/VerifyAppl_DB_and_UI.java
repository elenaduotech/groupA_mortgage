package step_definitions2;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;
import pages.ApplicationListPage;
import pages.DPage;
import pages.MainPage;
import pages.MortgageApplicationPage;
import pages.NPage;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;

public class VerifyAppl_DB_and_UI {

	@Given("The user sign-ins and enters all information for the application")
	public void theUserSignInsAndEntersAllInformationForTheApplication() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		SignInPage sp = new SignInPage();
		sp.email.sendKeys(ConfigReader.getProperty("emailAddress"));
		sp.password.sendKeys(ConfigReader.getProperty("emailPassword"));
		sp.loginButton.click();

		MainPage mp = new MainPage();
		mp.mortgageApplication.click();
		MortgageApplicationPage ma = new MortgageApplicationPage();
		ma.realtorInfo.sendKeys(ConfigReader.getProperty("realtorName"));
		ma.estimatedPurchasePrice.sendKeys(ConfigReader.getProperty("estimatedPurchase"));
		ma.downpaymentPercentage.sendKeys("5");
		ma.nextButton.click();

		ma.borrowerFirstName.sendKeys(ConfigReader.getProperty("firstName"));
		ma.borrowerMiddleName.sendKeys(ConfigReader.getProperty("midName"));
		ma.borrowerLastName.sendKeys(ConfigReader.getProperty("lastName"));
		ma.borrowerEmail.sendKeys(ConfigReader.getProperty("emailAddress"));
		ma.borrowerDob.sendKeys(ConfigReader.getProperty("borrowerDOB"));
		ma.borrowerSsn.sendKeys(ConfigReader.getProperty("borrowerSSN"));
		new NPage().maritalStatusDropdownBox.click();
		new NPage().inputBox.sendKeys("Married" + Keys.ENTER);
		ma.borrowerCellPhoneNo.sendKeys(ConfigReader.getProperty("cellNO"));
		ma.nextButton.click();

		ma.monthlyPaymentField.sendKeys("500");
		ma.nextButton.click();

		ma.employerName.sendKeys(ConfigReader.getProperty("employer"));
		DPage dp = new DPage();
		dp.position.sendKeys(ConfigReader.getProperty("position"));
		dp.city.sendKeys(ConfigReader.getProperty("city"));
		Select s = new Select(dp.state);
		s.selectByValue("AK");
		dp.startDate.sendKeys(ConfigReader.getProperty("jobstart"));
		dp.income.sendKeys(ConfigReader.getProperty("income"));
		ma.nextButton.click();
		ma.nextButton.click();

		ma.eConsentdeclarerFirstName.sendKeys(ConfigReader.getProperty("firstName"));
		ma.eConsentdeclarerLastName.sendKeys(ConfigReader.getProperty("lastName"));
		ma.eConsentdeclarerEmail.sendKeys(ConfigReader.getProperty("emailAddress"));
		ma.agreeBox.click();
		ma.nextButton.click();

		ma.saveButton.click();
		String actualMessage = ma.successMessage.getText();
		String expectedMessage = "Application Submiited Successfully";
		assertEquals(expectedMessage, actualMessage);

	}

	@When("The user click on the Application List")
	public void theUserClickOnTheApplicationList() {
		new MainPage().applicationList.click();
		new ApplicationListPage().viewDetailsButton.click();
	}

	@Then("The user information should match the database")
	public void theUserInformationShouldMatchTheDatabase() {
		DPage dp = new DPage();
		String expectedRealtorName = dp.realtorInfo.getText();
		String expectedPurchasePrice = dp.estimatedPurchasePrice.getText();
		String expectedFullName = dp.fullName.getText();
		String expecteddob = dp.dob.getText();
		String expectedSSN = dp.ssn.getText();
		String maritalStatus = dp.maritalStatus.getText();

		String request = "select * from tbl_mortagage where id='210'";
		List<Map<String, Object>> list = DBUtils.getQueryResultMap(request);
		Map<String, Object> map = list.get(0);

		String actualRealtorName = (String) map.get("realtor_info");
		String actualPurchasePrice = (String) map.get("est_purchase_price");
		String actualfullName = (String) map.get("b_firstName") + " " + (String) map.get("b_middleName");
		String actualdob = (String) map.get("b_dob");
		String actualssn = (String) map.get("b_ssn");
		String actualmaritalStatus = (String) map.get("b_marital");

		assertEquals(expectedRealtorName, actualRealtorName);
		assertEquals(expectedPurchasePrice, actualPurchasePrice);
		assertEquals(expectedFullName, actualfullName);
		assertEquals(expecteddob, actualdob);
		assertEquals(expectedSSN, actualssn);
		assertEquals(maritalStatus, actualmaritalStatus);

	}

}
