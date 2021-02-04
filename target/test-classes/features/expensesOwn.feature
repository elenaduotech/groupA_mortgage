@nastya
Feature: User enters informtion about the housing

Background: 
	Given The user is on the Expenses page

Scenario: Own Option
	When The user click on the "Own" button
	Then The green check mark should be displayed
	
Scenario: Info Icon
	When The user clicks on the "i" icon
	Then No message shown
	
Scenario: The user enters the amount for the first Mortagage total payment
	When The user enters the "amount" 
	Then The user should be able to see the amount displayed
	And The user should be able to click on "Next" button