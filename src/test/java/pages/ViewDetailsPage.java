package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class ViewDetailsPage {
	
	public ViewDetailsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy (xpath = "((//table[@class='table'])[1]//td)[1]")
	public WebElement borrowerName;
	
	@FindBy (xpath = "((//table[@class='table'])[1]//td)[3]")
	public WebElement dateOfBirth;
	
	@FindBy (xpath = "((//table[@class='table'])[1]//td)[4]")
	public WebElement ssn;
	
	

}
