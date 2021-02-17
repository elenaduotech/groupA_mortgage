Feature: Verify data base updated information
		
	
	Scenario: Update user phone Number in DB and verify the change in DB
	   When I update user phone number with "2405550000" for a user with id "2367"
       Then Verify that user has updated phone number
       
    @db_only
	Scenario: Update user information in DB and verify the change in DB
	   When I update user "<down_payment_percent>" for a user with "<id>"
       Then Verify that user has updated information
    
      