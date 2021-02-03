Feature: Verify customer Sign in information
		
	Background:
	Given : The user is on homepage
		
		
	Scenario: Verify positive login
		When : The user enter correct email and password and clicks Login
	    Then : The user should see his name 
	
	
	
	Scenario: Verify negative log in
		When : The user enter wrong email and correct password and clicks Login
	    Then : The user should not login and the error message should appear
	
	