Feature: Search For Buses

  Scenario: Searching for buses with valid details
    Given I am on the eseat home page
    When I enter from location as "Colombo" and to location as "Jaffna"
    And I enter "2025-01-30" as the travel on data
    And I click the search buses button
    Then I should be navigated to bus Search results page