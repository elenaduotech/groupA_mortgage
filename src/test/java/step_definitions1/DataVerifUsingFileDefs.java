package step_definitions1;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.SignInPage;
import pages.SignUpPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;


public class DataVerifUsingFileDefs {
	
	@Then("The user enters information about mortgage using Excel file and get failure message because he forgot to enter")
	public void theUserEntersInformationAboutMortgageUsingExcelFileAndGetFailureMessageBecauseHeForgotToEnter() {
	    
SignInPage sp = new SignInPage();
		
		sp.mortgageApplication.click();
		
		BrowserUtils.waitFor(5);
		ExcelUtils sheet = new ExcelUtils("src/test/resources/testData/testDataElena.xlsx", "Sheet1");
		
		List<Map<String, String>> rows = sheet.getDataAsMap();
		
		BrowserUtils.waitForClickablility(sp.realtorEmail, 6);
		
		for (int i = 0; i < rows.size(); i++) {
			
			Map<String, String> map = rows.get(i);
			
			   
			    	 
			    	 String realtorEmail = map.get("RealtorEmail");
			    	 String estimatedPurchasePrice = map.get("EstimatedPurchasePrice");
			    	 String downPaymentAmount = map.get("DownPaymentAmount");
			    	 String firstName = map.get("FirstName");
			    	 String lastName = map.get("LastName");
			    	 
			    	sp.realtorEmail.sendKeys(realtorEmail);
			    	sp.estimatedPurchasePriceButton.sendKeys(estimatedPurchasePrice);
			    	sp.downPaymentButton.sendKeys(downPaymentAmount);
			    	sp.nextButton.click();
			    	
			    	sp.firstNameOfApplicant.sendKeys(firstName);
			    	sp.lastNameOfApplicant.sendKeys(lastName);
			    	sp.nextButton.click();
			    	int actualNumberOfErrorMessages = sp.listOfErrorMessages.size();
			    	int expectedNumberOfErrorMessages = 4;
			    	
			    	 try {
			    		 assertEquals(expectedNumberOfErrorMessages, actualNumberOfErrorMessages);
				    sheet.setCellData("PASS", "Status", i+1);					    	 
				    if(i == rows.size()-1) {

			    		 sp.logOut.click();
			    		 sp.logOutButton.click();
			    	 }else {
			    		 sp.mortgageApplication.click();
			    	 }
				    	 
			    	 }catch(AssertionError e) {
			    		 sheet.setCellData("FAIL", "Status", i+1);
			    	 
			    	 if(i == rows.size()-1) {

			    		 sp.logOut.click();
			    		 sp.logOutButton.click();
			    	 }else {
			    		 sp.mortgageApplication.click();
			    	 }
			    	 
			    	 
			    	 } 

	    	 
		
	}}

	
}
