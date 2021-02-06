@nastya
Feature: Personal Information
	As the user I want to be able to enter all required information
	
	Background:
		Given The user is on the Personal Information page
		
Scenario: Co-borrower option with no 
	When The user chooses "no"
	Then The user should see red check mark next to "no" option
	
Scenario: One borrower
	When If the user enter "no" for co-borrower
	Then The user should be able to put all required information
	And The user clicks on the "Privacy Policy"
	And The user clicks "Next" button
	
Scenario: Co-borrower option with yes 
	When The user click on "yes"
	Then The user should be able to see the blue check mark next to "yes" option
	
Scenario: The user enters personal information for both borrowers
	When The user enters the required personal information for first borrower
	Then The user should be able to put the co-borrower personal information
	And The user should be able to click on the "Next" button