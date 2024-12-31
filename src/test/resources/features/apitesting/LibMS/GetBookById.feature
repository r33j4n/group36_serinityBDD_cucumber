Feature: Retrieve a book by ID
  As an authenticated user
  I want to retrieve a book by its ID
  So that I can see its details or know if it doesn't exist

  Scenario: Book not found with the given ID
    Given I am logged in as an admin
    And the database does not contain a book with ID 888
    When I send a GET request to "/api/books/888"
    Then I should receive a 404 response codes