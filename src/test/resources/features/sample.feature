Feature: OrangeHRM application


  @smoke
  Scenario: Verify the home page
    Given user launches application
    When user enters the credentials and clicks on login
    Then user validates title page
    And user closed the application

  @smoke
  Scenario: Verify the home page
    Given user launches application
    When user enters the credentials and clicks on login
    Then user validates title page
    And user closed the application

#    hello manju

    @regression
 Scenario Outline: Update Employee Details
    Given user launches application
    When user enters the credentials and clicks on login
    Then user Navigates to MyInfo
    Then user Enters Employee Details
    Then user Saves the Details
    And user closed the application
      Examples:
        | username | password |  |
        | Admin    | admin12  |  |
        | admin    | admin123 |  |


