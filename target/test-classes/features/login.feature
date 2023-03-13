@RegressionSuit
Feature: Validating the Login functionality
      validating login functionality with positive and negative scenario and multiple dataset
    
    Background: User navigation to the application and Open the Home screen to test all the Scenario mentioned below
    Given User open the Browser and Navigated to the Application Url
    Then User should redirected to the home screen
    When User click on Login button 
    
    
    Scenario: Validating login test with positive data set
    Given User will be on Login Screen
    When  User Enter the username
    And   User Enter the password
    And   User click on Submit button
    Then  User should login successfully
    