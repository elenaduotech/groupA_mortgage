   @test
Feature: Register new user and log in
    
	Scenario: Register new user
	   Given First name, last name, email and password
	   When User enters this information
       Then User is registered in the system
       

	Scenario: Verify log in 
	   Given Email and password
	   When User enters email and password
	   Then User is able to successfully logged in
	  
    
      