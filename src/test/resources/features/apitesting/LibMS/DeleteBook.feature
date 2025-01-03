Feature: Delete Book by ID
  As an authenticated user
  I want to delete a book by its ID
  So that I can remove a book from the Library

  Scenario: Unauthorized deletion attempt by user
    Given I am logged in as a user
    And book is already available
    """
        {
          "id": 1,
          "title": "Unauthorized deletion by user",
          "author": "Sagini"
        }
    """
    When I send delete request with valid ID
    Then I should receive a 403 response code

  Scenario: Unauthorized deletion attempt
    Given I am not authenticated
    When I send a DELETE request to "/api/books/1"
    Then I should receive a 401 response code

  Scenario: Successfully delete a book with a valid ID by admin
    Given I am logged in as an admin
    And a book exists in the database with ID 1
    When I send a DELETE request to "/api/books/1"
    Then I should receive a 200 response code

  Scenario: Delete a non-existing book by admin
    Given I am logged in as an admin
    And the database does not contain a book with ID 100
    When I send a DELETE request to "/api/books/100"
    Then I should receive a 404 response code

  Scenario: Delete a non-existing book by user
    Given I am logged in as a user
    And the database does not contain a book with ID 100
    When I send a DELETE request to "/api/books/100"
    Then I should receive a 403 response code