@Login

Feature: Login feature
  
  Description: This feature will be used to login to SwagLab Application

@PositiveSceanrio
  Scenario Outline: Verify that when use enters correct username and password they should able to login successfully
    Given User open the SwagLab Application
    When User enter the correct username "<Username>"
    And User enter the correct password  "<Password>"
    And User click on login button
    Then User should be navigated to product page successfully

    Examples: 
      |Username|Password|
      | standard_user | secret_sauce |
      
      
      
@NegativeSceanrio
  Scenario Outline: Verify that when use enters wrong username and password they should able to login successfully
    Given User open the SwagLab Application
    When User enter the wrong username "<Username>"
    And User enter the wrong password  "<Password>"
    And User click on login button
    Then User should get error message

    Examples: 
       |Username|Password|
      | standard_user | sauce|
