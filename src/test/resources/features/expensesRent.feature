@nastya
Feature: User enters rent information

Background: 
	Given The user is on the Expenses page

Scenario: Rent Option
	When The user click on the "Rent" button
	Then The blue check mark should be displayed
	
Scenario: The user enters monthly rental payment as letters
	When The user enters the letters
	Then The message should be displayed on the page "Please Enter a Valid Number"
	
Scenario: The user enters the amount for the rental payment
	When The user enters the "amount" 
	Then The user should be able to see the amount displayed
	And The user should be able to click on "Next" button