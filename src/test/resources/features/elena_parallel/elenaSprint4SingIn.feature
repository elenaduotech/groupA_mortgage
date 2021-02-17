Feature: Verify customer Sign in information
		
	Background:
	Given The user is on homepage
		
		
	Scenario: Verify positive login
		When The user enter correct email and password and clicks Login
		Then The user should see his name 
	
	

	Scenario Outline:: Verify negative log in
		When The user enters "<email>" and "<wrong_password>" and clicks Login
		Then The user should not login and the error message should appear
		 
		  Examples:
         |       email            |    password    |
         |  vickyrid@mc.com       |   12345v       |
         |  jackpom@mc.com        |   6789j        |
         |  kentsmith@mc.com      |   98765k       |
	   
	
	 
	Scenario: Verify log out
		When The user enter correct email and password and clicks Login
		When The user clicks on picture image and presses Log out
		Then The user should log out and land on homepage with Welcome Back, Automation Testers! message
	