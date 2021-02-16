Feature: Verify moving icons on Mortgage Application Page
		
	@ui_db
	Scenario: Update user email in DB and verify the change on the UI
	   When I update user email with "sophiayeng@mc.com" for a user with id "2367"
       Then Check if user can login using updated email info and see user's name "Sophia Yen"
      