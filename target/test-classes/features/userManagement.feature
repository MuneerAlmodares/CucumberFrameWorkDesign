@regression
Feature: Crater user Management
  user management focuses on user creation, update and delete and also authintication.
  
  @validLoginTest
  Scenario: user is able to login successfully
    Given user is on the login page
    When user enters VALID "muneralmodares93@gmail.com" AND "Password1234"
    And clicks on the login button
    Then user should be on the dashboard page
    
    @invalidlogin
    Scenario: Invalid login attempts
     Given user is on the login page 
     When user enters invalid "bobma@gmail.com" and "hawwai"
     And click login button      
     Then an error message appears
     And user is not logged in
     And user quits the browser 		
     
     @invalidloginOutLine
     Scenario Outline: Invalid login attempts
     Given user is on the login page
     When user enters invalid useremail "<useremail>" and password "<passweord>"
     And clicks on the login button
     Then error messages appear
     And user is not logged in
     And user quits the browser
     
     
     Examples:
     |useremail                      | passweord     |
     |muneralmodares93@gmail.com     | hsdjfF23      |
     |fakeaccount@primetechschool.com| jjG4343       |
     |                               | testng33      |
     |fakeacount@primetechschool.com |               |
