@RegressionSuit
Feature: Validating the functionality associated with the Home Screen of the application
  This feature file will have all the Scenario associated with the home screen
  for, UI as well as functional perspective

  Background: User navigation to the application and Open the Home screen to test all the Scenario mentioned below
    Given User open the Browser and Navigated to the Application Url
    When User click on Shop Menu
    And Now click on Home menu button
    Then User should redirected to the home screen
    
    Scenario: Home page with Three Slider and Three Arrivals only
    Then Test whether the Home page has Three Sliders only
    And Test whether the Home page has Three Arrivals only
    
  
 
  

  
  
    

   

  