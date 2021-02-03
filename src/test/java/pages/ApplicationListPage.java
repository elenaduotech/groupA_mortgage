package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class ApplicationListPage {
	
	public ApplicationListPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy (xpath = "((//tr[@role='row'])[2]/td)[2]")
	public WebElement borrowerName;
	
	@FindBy (xpath = "((//tr[@role='row'])[2]/td)[3]")
	public WebElement loanAmount;
	
	@FindBy (xpath = "//a[@href='mortagageloandegtails.php?id=163']")
	public WebElement viewDetailsButton;
	
	
	
	
	

}
