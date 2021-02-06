@nastya 
Feature: Preapproval Details 
	As as user I want to be able to put my information for the Preapproval details
	
Background: 
	Given The user in on the Preaproval details page 
	
Scenario: Realtor option with no
	When The user chooses "no" for question
	Then The user should not be able to put any information in Realtor Information Box 
	And The user should see red check mark next to "no" option
	
Scenario: Realtor option with yes
	When The user chooses "yes" for question
	Then The user should be able to put in "name" and "phone number" and "email adrress" of the realtor
	And The user should be able to see the blue check mark next to "yes" option
		
Scenario: Loan officer option with no 
	When The user chooses "no"
	Then The user should see red check mark next to "no" option
	
Scenario: Loan officer option with yes 
	When The user click on "yes"
	Then The user should be able to see the blue check mark next to "yes" option
	
Scenario Outline: Puprose of the loan negative entrees 
	When The user enters the "<purpose>" 
	Then The system should not recognize the entrees and display the "<message>" 
	Examples: 
		|			purpose				|			message				|
		|		Business Purchase		|		No result found			|
		|		Condominium				|		No result found			|
		|		Apartment Purchase		|		No result found			|
		
		
Scenario: Puprose of the loan positive entrees 
	When The user enters purpose of the loan as "Purchase Home" 
	Then The result is found 
	
Scenario Outline: Estimated purchase price with numbers 
	When The user enters "<amount>" for estimated purchase 
	And The user enters "<down payment>" 
	Then The user should see displayed "<down payment percentage>" 
	And The message should display the "<loan amount>" 
	Examples: 
		|amount	|down payment	|	down payment percentage	|	loan amount	|
		|500000	|	20000		|	4						|	480000 $	|
		|25000	|	2000		|	8						|	23000 $		|
		|12800	|	128			|	1						|	12672 $		|
		
Scenario: Source of payment 
	When The user clicks on the drop down menu for  the source of payment 
	Then The user should see following options 
		|	Checking/Savings (most recent bank statement)	|
		|	Equity on Pending Sale (executed sales contract)|
		|	Other type of Down Payment						|
		
Scenario: Additional founds 
	When The user enters the text 
	Then Text should be displayed 
	And The user shoud be able to enter the "Next" button 
	
	