package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

	public class MortgageApplicationPage {
		
		public MortgageApplicationPage() {
			PageFactory.initElements(Driver.getDriver(), this);
		}
		
		
		@FindBy (xpath = "//label[@for='realtor1']")
		public WebElement workWithRealtorYesBox;
		
		@FindBy (xpath = "//label[@for='realtor2']")
		public WebElement workWithRealtorNoBox;
		
		@FindBy (id = "realtorinfo")
		public WebElement realtorInfo;
		
		@FindBy (xpath = "//label[@for='loanofficer1']")
		public WebElement workWithLoanOfficerYesBox;
		
		@FindBy (xpath = "//label[@for='loanofficer2']")
		public WebElement workWithLoanOfficerNoBox;
		
		
		@FindBy (id = "select2-purpose_loan-j7-container")
		public WebElement purposeOfLoanDropdownBox;
		
		@FindBy (id = "estimatedprice")
		public WebElement estimatedPurchasePrice;
		
		@FindBy (id = "downpaymentpercentage")
		public WebElement downpaymentPercentage;
		
		@FindBy (id = "downpayment")
		public WebElement downpaymentAmount;
		
		@FindBy (xpath = "//div[@class='loanamount']")
		public WebElement loanAmount;
		
		@FindBy (xpath = "//span[@id='select2-src_down_payment-mn-container']")
		public WebElement sourceOfDownpaymentDropdownBox;
		
		@FindBy (xpath = "additionalfunds")
		public WebElement additionalFunds;
		
		@FindBy (xpath = "//a[@href='#next']")
		public WebElement nextButton;
		
		@FindBy (xpath = "//label[@for='coborrower1']")
		public WebElement coborrowerYesBox;
		
		@FindBy (xpath = "//label[@for='coborrower2']")
		public WebElement coborrowerNoBox;
		
		
		@FindBy (id = "b_firstName")
		public WebElement borrowerFirstName;
		
		@FindBy (id = "b_middleName")
		public WebElement borrowerMiddleName;
		
		@FindBy (id = "b_lastName")
		public WebElement borrowerLastName;
		
		@FindBy (id = "select2-b_suffix-container")
		public WebElement suffixDropdownBox;
		
		@FindBy (id = "b_email")
		public WebElement borrowerEmail;
		
		@FindBy (id = "b_dob")
		public WebElement borrowerDob;
		
		@FindBy (id = "b_ssn")
		public WebElement borrowerSsn;
		
		@FindBy (xpath = "(//span[@class='select2-selection__arrow'])[3]")
		public WebElement maritalStatusDropdownBox;
		
		@FindBy (xpath = "//li[@id='select2-b_marital-result-0t2t-Married']")
		public WebElement marriedOption;
		
		
		@FindBy (id = "b_cell")
		public WebElement borrowerCellPhoneNo;
		
		@FindBy (id = "b_home")
		public WebElement borrowerHomePhoneNo;
		
		@FindBy (xpath = "//label[@for='privacypolicy']")
		public WebElement privacyPolicyBox;
		
		@FindBy (xpath = "//a[@href='#previous']")
		public WebElement previousButton;
		
		@FindBy (xpath = "//label[@for='expense1']")
		public WebElement rentBox;
		
		@FindBy (xpath = "//label[@for='expense2']")
		public WebElement ownBox;
		
		@FindBy (id = "monthlyrentalpayment")
		public WebElement monthlyPaymentField;
		
		@FindBy (xpath = "//a[@href='#employer1']")
		public WebElement employer1;
		
		@FindBy (id = "currentjob1")
		public WebElement currentJobBox;
		
		@FindBy (id = "employername1")
		public WebElement employerName;
		
		
		@FindBy (id = "grossmonthlyincome")
		public WebElement grossMonthlyIncome;
		
		@FindBy (id = "monthlyovertime")
		public WebElement monthlyOvertime;
		
		@FindBy (id = "monthlybonuses")
		public WebElement monthlyBonuses;
		
		@FindBy (id = "monthlycommission")
		public WebElement monthlyCommission;
		
		@FindBy (id = "monthlydividents")
		public WebElement monthlyDividents;
		
		@FindBy (xpath = "//div[@class='loanAmountdiv']/lebel")
		public WebElement borrowerTotalIncome;
		
		@FindBy (xpath = "//label[@for='creditreport1']")
		public WebElement preapprovalInquiryYesBox;
		
		@FindBy (xpath = "//label[@for='creditreport2']")
		public WebElement preapprovalInquiryNoBox;
		
		@FindBy (id = "eConsentdeclarerFirstName")
		public WebElement eConsentdeclarerFirstName;
		
		@FindBy (id = "eConsentdeclarerLastName")
		public WebElement eConsentdeclarerLastName;
		
		@FindBy (id = "eConsentdeclarerEmail")
		public WebElement eConsentdeclarerEmail;
		
		@FindBy (xpath = "//label[@for='agree']")
		public WebElement agreeBox;
		
		@FindBy (xpath = "//label[@for='dontagree']")
		public WebElement dontAgreeBox;
		
		@FindBy (xpath = "//a[@href='#finish']")
		public WebElement saveButton;
		
		@FindBy (xpath = "//div[@class='alert alert-succes']")
		public WebElement successMessage;
		
		
		
		
		
		

}
