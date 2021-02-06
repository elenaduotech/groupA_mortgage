Feature: Verify moving icons on Mortgage Application Page
		
	@temp
	Scenario: Verify positive login
	    Given The user is on homepage
		When The user enter correct email and password and clicks Login
		Then The user should click on Mortgage Application 
		And When the user hover over picture icons, icon should move