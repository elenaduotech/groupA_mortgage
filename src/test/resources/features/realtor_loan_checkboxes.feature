@nastya1
Feature: Realtor Information
As a user when I choose no for realtor I should not be able to enter their information
	
Scenario: Realtor option with no
	Given The user in on the Main Page
	When The user click on the Mortgage Application
	And The user chooses no for question
	Then The user should not be able to put any information in Realtor Information Box 

Scenario: Realtor option with yes
	When The user chooses yes for question
	Then The user should be able to put in info of the realtor
	When The user chooses no for loan officer
	Then The user should see check mark next to no option
	When The user click on yes
	Then The user should be able to see check mark next to yes option
	