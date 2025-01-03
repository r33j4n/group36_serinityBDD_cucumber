Feature: Submit Contact us form

  Scenario: Submit the Contact Us form successfully
    Given I am on the contact page
    When I fill out the contact us form with Name: "Anusha" email address: "anusha123@gmail.com" Mobile Number: "712345627" and Message: "Nice Bus Service"
    And I submit the form
    Then I should see the success message "Your message has been sent"