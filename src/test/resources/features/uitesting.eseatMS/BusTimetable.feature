Feature: Search For Bus Timetable

  Scenario: Searching for bus timetable
    Given I am on the eseat home page
    And I click the BUS TIME TABLE button
    When I enter from location as "Colombo"
    And I enter to location as "Jaffna"
    And I enter start time as "06:00"
    And I enter end time as "12:00"
#    And I enter bus type as "Any"
    And I click the search button
    Then I should be navigated to bus timetable results page