package step_definitions1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.SignInPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;


public class JavaScriptVerifDefs {
	@Then("The user should click on Mortgage Application")
	public void theUserShouldClickOnMortgageApplication() {
	   SignInPage sp = new SignInPage();
	   
	   sp.mortgageApplication.click();
	      
	}

	@Then("When the user hover over picture icons, icon should move")
	public void whenTheUserHoverOverPictureIconsIconShouldMove() {
		
		 SignInPage sp = new SignInPage();
		 BrowserUtils.waitForPageToLoad(3);
		
	    BrowserUtils.waitForVisibility(sp.movingIcon, 4);
	     
	    		
		String expectedStroke = "stroke: rgb(92, 107, 124);";
	 BrowserUtils.hover(sp.movingIcon);

		
		String actualStroke = sp.movingIcon.getAttribute("style");
		
	assertTrue(actualStroke.equals(expectedStroke));
	
	
}}
