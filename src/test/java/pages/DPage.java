package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class DPage {


	public DPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy (xpath = "//a[@class='clear']")
	public WebElement clearButton;
	
	@FindBy (xpath = "//div[@role='dialog']")
	public WebElement popupClearDialogWindow;
	
	@FindBy (xpath = "//h2[@class='swal2-title']")
	public WebElement popupHeader;
	
	@FindBy (xpath = "//button[@class='swal2-cancel btn btn-danger ml-1']")
	public WebElement cancelButtonPop;
	
	@FindBy (xpath = "//button[@class='swal2-confirm btn btn-warning']")
	public WebElement yesButtonPop;
	
	@FindBy (id = "position1")
	public WebElement position;
	
	@FindBy (name = "city[]")
	public WebElement city;
	
	@FindBy (id = "state1")
	public WebElement state;
	
	@FindBy (name = "start_date[]")
	public WebElement startDate;
	
	@FindBy (id = "employername1")
	public WebElement employerName;
	
	@FindBy (id = "addemployer")
	public WebElement addEmployer;
	
	@FindBy (xpath = "(//a[@href='#employer2'])[2]")
	public WebElement employer2;
	
	@FindBy (id = "remove2")
	public WebElement remove;
	
	@FindBy (id = "swal2-title")
	public WebElement popupHeader2;
	
	@FindBy (id = "grossmonthlyincome")
	public WebElement income;
	
	@FindBy (xpath = "(//table//td)[2]")
	public WebElement realtorInfo;
	
	@FindBy (xpath = "(//table//td)[5]")
	public WebElement estimatedPurchasePrice;
	
	@FindBy (xpath = "(//table//td)[12]")
	public WebElement fullName;
	
	@FindBy (xpath = "(//table//td)[14]")
	public WebElement dob;
	
	@FindBy (xpath = "(//table//td)[15]")
	public WebElement ssn;
	
	@FindBy (xpath = "(//table//td)[16]")
	public WebElement maritalStatus;
	
	@FindBy (xpath = "(//table//td)[21]")
	public WebElement employer;
//	
//	@FindBy (id = "swal2-title")
//	public WebElement popupHeader2;
}
