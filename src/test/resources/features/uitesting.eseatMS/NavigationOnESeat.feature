Feature: Navigation to components

  Scenario: Successful navigation to send ticket page
    Given I am on the eseat home page
    When I click send ticket button
    Then I should be navigated to send ticket page

  Scenario: Verify WhatsApp icon redirects to the correct WhatsApp page
    Given I am on the home page
    When I click on the WhatsApp icon
    Then I should be redirected to the WhatsApp page

