@nastya
Feature: Borrower Employment Information

Background: 
	Given The user is on the Employment and Income page

Scenario: Clear button
	When The user click on the "Clear" button
	Then The message popUp should appear
	And The message should display "Clear Employer1 Data?"
	And The user should be able to pick "Yes" or "Cancel" button
	
Scenario: Current job
	When The user clicks on the "This is my current job" check box
	Then The "End date" should dissapier
	
Scenario: Enter the Emloyer Information
	When The user enters the Employer Information
	Then The user should be able to lick on the "Add Another Employer" button
	