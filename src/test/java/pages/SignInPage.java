package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SignInPage {
	
	public SignInPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy (id = "exampleInputEmail1")
	public WebElement email;
	
	@FindBy (id = "exampleInputPassword1")
	public WebElement password;
	
	@FindBy (name = "login")
	public WebElement loginButton;
	
	@FindBy (xpath = "//a[@href='register.php']")
	public WebElement signUp;
	
	@FindBy (className = "user-name")
	public WebElement userNameVerification;
	
	@FindBy (xpath = "//*[@class='card-header pb-1']")
	public WebElement loginFailedMessage;
	

	@FindBy (className = "round")
	public WebElement logOut;
	
	@FindBy (className = "dropdown-item")
	public WebElement logOutButton;
	
	@FindBy (xpath = "(//*[@class='menu-item'])[1]")
	public WebElement mortgageApplication;
	
	
	@FindBy (id = "realtorinfo")
	public WebElement realtorEmail;
	
	@FindBy (name = "est_purchase_price")
	public WebElement estimatedPurchasePriceButton;
	
	@FindBy (id = "downpayment")
	public WebElement downPaymentButton;
	
	@FindBy (xpath = "//a[@href=\"#next\"]")
	public WebElement nextButton;
	
	@FindBy (id = "b_firstName")
	public WebElement firstNameOfApplicant;
	
	@FindBy (id = "b_lastName")
	public WebElement lastNameOfApplicant;
	
	@FindBy (xpath = "//div[@class='row col-12']//*[@class='danger']")
	public List<WebElement> listOfErrorMessages;
	
	
	@FindBy (xpath = "//a[@href=\"#previous\"]")
	public WebElement previousButton;
	
	@FindBy (id = "estimatedprice-error")
	public WebElement estimatedPriceError;
	
//	@FindBy (xpath = "//*[@clip-path=\"url(#livicon_settings_solid_15)\"]")
//	public WebElement movingIcon;
	
	@FindBy (xpath = "//*[@id='livicon_settings_solid_15']//*[@class=\"lievo-donotdraw lievo-nohovercolor\"]")
    public WebElement movingIcon;
	
	
}
