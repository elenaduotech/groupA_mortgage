@db
Feature: Verify database integrity
Scenario: Verify users information

Given Get connected to db and receive information about the user
Then verify if firstname lastname and email is as expected

|Jo |Biden | jbiden@gmail.com |