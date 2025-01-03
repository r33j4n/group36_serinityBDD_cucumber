Feature: Delete Book by ID
  As an authenticated user
  I want to delete a book by its ID
  So that I can remove a book from the Library

  Scenario: Delete a book which is not exist in the library
    Given I am logged in as an admin
    And the database does not contain a book with ID 2
    When I send a DELETE request to "/api/books/2"
    Then I should receive a 404 response code

  Scenario: Unauthorized deletion attempt by user
    Given user logged in
    And book is already available
    When user sends delete request with valid ID
    Then the status code should be 403

  Scenario: Unauthorized deletion attempt
    Given unauthorized login attempt
    When send delete request with ID 1
    Then the status code should be 401

  Scenario: Successfully delete a book with a valid ID by admin
    Given I am logged in as an admin
    And a book exists in the database with ID 1
    When I send a DELETE request to "/api/books/1"
    Then I should receive a 200 response code

