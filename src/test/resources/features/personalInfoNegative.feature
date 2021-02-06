@nastya
Feature: Personal Information
	The user does not provide any personal information
	
	Background:
		Given The user is on the Personal Information page
		
	Scenario: Co-borrower option with no 
	When The user chooses "no"
	Then The user should see red check mark next to "no" option
	
Scenario: Co-borrower option with yes 
	When The user click on "yes"
	Then The user should be able to see the blue check mark next to "yes" option
	
Scenario: No personal information
	When The user click on "Next"
	Then The page should contain the red message "This field is required."
	And The user should stay on the same page