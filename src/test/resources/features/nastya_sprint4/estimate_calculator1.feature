@regression
Feature: Estimated purchase price
	As a user I want to calculate my loan amount by entering the down payment and percentage
	
Background: 
	Given The user in on Main Page
	And The user clicks on the Mortgage Application
	
	Scenario Outline: Estimated purchase price with down payment amount 
	When The user enters "<amount>" for estimated purchase 
	And The user enters "<down payment>"
	And The message should display the "<loan amount>" 
	Examples: 
		|amount	|down payment	|	loan amount	|
		|500000	|	20000		|	480000 $	|
		|25000	|	2000		|	23000 $		|
		|12800	|	128			|	12672 $		|
		

Scenario: Source of payment 
	When The user clicks on the drop down menu for  the source of payment 
	Then The user should see following options 
		|	Checking/Savings (most recent bank statement)	|
		|	Equity on Pending Sale (executed sales contract)|
		|	Other type of Down Payment						|
	And The user clicks Next