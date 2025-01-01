Feature: Delete Book by ID
  As an authenticated user
  I want to delete a book by its ID
  So that I can remove a book from the Library

  Scenario: Delete a book which is not exist in the library
    Given I am logged in as an admin
    And the database does not contain a book with ID 2
    When I send a DELETE request to "/api/books/2"
    Then I should receive a 404 response code
#    Then I should receive 404 status code