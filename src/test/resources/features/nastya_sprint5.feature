@db_test
Feature: Verify if application information correctly map with database 

Scenario: Verify sign-in details are correctly mapped with the DB 
	Given The user is on the sign-in page enter correct credentials 
	Then The users name should be displayed as a user 
	And User details should be mapped correctly in the database 
	
Scenario: Verify that user information matches information in database 
	Given The user sign-ins and enters all information for the application 
	When The user click on the Application List 
	Then The user information should match the database 
	
Scenario: Verify user employer match the database 
	Given The user Sign in 
	When The user click on the Application List and View Details 
	Then The employer information should match t database 
	
Scenario: Verify column names on DB 
	When The user retrieves column names from the "tbl_user" table 
	Then The names of the column should be the following 
		|	id			|
		|	email		|	
		|	password	|
		|	first_name	|
		|	last_name	|	
		|	phone		|
		|	image		|
		|	type		|	
		|	created_at	|
		|	modified_at	|
		|	zone_id		|	
		|	church_id	|
		|	country_id	|	
		|	active		|
		
Scenario: Verify duplicate names in DB 
	When The user retrieve duplicate "first_name" from the "tbl_user" table 
	Then The names should be as follows 
		|	Duotech	|
		|	JAck	|
		|	Julia	|
		|	Angelina|
		|	Elmer	|
		|	Sophia	|