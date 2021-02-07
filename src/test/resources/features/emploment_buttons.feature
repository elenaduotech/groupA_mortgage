@nastya
Feature: Employement and Income Page Functionality

Background: 
	Given The user is on the Main Page and enters all necessary information
	And The user is on the Employment and Income page

Scenario: Clear button
	When The user click on the Clear button
	Then The message popUp should appear
	And The message should display "Clear Employer1 Data?"
	And The user should be able to pick Cancel button
	
Scenario: Current job
	When The user enters employer information
	Then The user clicks on the Clear Button
	And The user clicks on Yes to clear all employer information
	And The users information should be cleared
	
Scenario: Enter the Emloyer Information
	When The user should be able to click on the Add Another Employer button
	Then The user should be able to see the Employer2
	
Scenario: Remove second Employer
	When The user click on the Add Another Employer
	Then The user should be able to click on the Remove button
	And The popUp message should appier with a message "Remove Employer2?"
	And The user should be able to click Yes
	