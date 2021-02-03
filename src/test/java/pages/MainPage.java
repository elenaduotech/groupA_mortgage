package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class MainPage {
	
	public MainPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy (xpath = "//span[@class='menu-title']")
	public WebElement dashboard;
	
	@FindBy (xpath = "(//span[@class='menu-item'])[1]")
	public WebElement mortgageApplication;
	
	@FindBy (xpath = "(//span[@class='menu-item'])[2]")
	public WebElement applicationList;
	
	@FindBy (xpath = "//i[@class='toggle-icon font-medium-4 d-none d-xl-block primary bx bx-disc']")
	public WebElement toggleIcon;
	
	
	
	
	
	

}
