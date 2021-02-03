package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SignUpPage {
	
	public SignUpPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy (id = "email")
	public WebElement emailSignUp;
	
	@FindBy (name = "first_name")
	public WebElement first_name;
	
	@FindBy (name = "last_name")
	public WebElement last_name;
	
	@FindBy (id = "exampleInputPassword1")
	public WebElement passwordSignUp;
	
	@FindBy (id = "register")
	public WebElement signUpButton;
	

}
