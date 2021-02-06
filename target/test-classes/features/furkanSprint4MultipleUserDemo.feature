@furkan
Feature: Verify application information

Background: 
		Given The User is on the homepage
    	When The user enters correct credentials and click on login

 	Scenario Outline: The user's information in application list should match with actual data
	Given The user enters following information in custom type "<firstName>","<lastName>", "<ssn>", "<dob>", "<cellPhoneNo>", "<email>", "<monthlyIncome>", "<maritalStatus>"
	When The user clicks on application list
	Then The user should see that the "<ssn>" information is right
	
	
	Examples:
|firstName  |lastName  |ssn        |dob       |cellPhoneNo  |email      |monthlyIncome   |maritalStatus  |
|Henry      |Biden     |123-45-6789|01/01/1945|111111111    |h@gmail.com|3000            |Married        |
|Alex       |Biden     |223-34-4555|01/01/1965|222222222    |a@gmail.com|5000            |Married        |
|Lily       |Biden     |987-65-4321|01/01/1985|333333333    |h@gmail.com|3000            |Married        |