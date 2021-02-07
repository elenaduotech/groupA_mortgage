@furkan
Feature: Verify application information with multiple user

Background: 
		Given The User is on the homepage
    	When The user enters correct credentials and click on login

 	Scenario: The user's information in application list should match with actual data
	Given The user enters following information to the mortgage application

	|name|lastName|ssn      |dob       |cellPhoneNo|email           |monthlyIncome|maritalStatus|
	|Jo  |Biden   |123456789|01/01/1945|987654321  |jbiden@gmail.com|10000        |Married      |

	When The user clicks on application list
	Then The user should see that the ssn dob information is right