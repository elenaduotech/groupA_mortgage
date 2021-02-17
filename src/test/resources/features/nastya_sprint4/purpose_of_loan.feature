@regression
Feature: Preapproval Inquiry
	As as user I should not be able to change the purpose of a loan
	
Background: 
	Given The user in on Main Page
	And The user clicks on the Mortgage Application
	
Scenario Outline: Puprose of the loan entrees 
	When The user clicks on the purpose of the loan and enters the "<purpose>" 
	Then The system should not recognize the entrees and display the "<message>" 
	Examples: 
		|			purpose				|			message				|
		|		Business Purchase		|		No results found			|
		|		Condominium				|		No results found			|
		|		Apartment Purchase		|		No results found			|
		
