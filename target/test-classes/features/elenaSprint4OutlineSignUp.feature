Feature: User registration feature
  
   
    Scenario Outline: Verify multiple user registration
    
        Given The User is on the homepage
        When The user clicks on Sign up button
        Then The user enters "<first_name>" and "<last_name>"
        And The user enters "<email>" and "<password>"
         And The user clicks Sign up button
        
        Examples:
         | first_name    |  last_name    |       email            |    password    |
         |    Vicky      |     Rid       |  vickyrid@mc.com       |   12345v       |
         |    Jack       |     Pom       |  jackpom@mc.com        |   6789j        |
         |    Kent       |     Smith     |  kentsmith@mc.com      |   98765k       |
        