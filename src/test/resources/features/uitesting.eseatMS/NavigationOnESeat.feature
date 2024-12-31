Feature: Navigation to components

  Scenario: Successful navigation to send ticket page
    Given I am on the eseat home page
    When I click send ticket button
    Then I should be navigated to send ticket page