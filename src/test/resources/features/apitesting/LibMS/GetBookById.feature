Feature: Retrieve a book by ID
  As an authenticated user
  I want to retrieve a book by its ID
  So that I can see its details or know if it doesn't exist

  Scenario: Book not found with the given ID
    Given I am logged in as an admin
    And the database does not contain a book with ID 888
    When I send a GET request to "/api/books/888"
    Then I should receive a 404 response codes

  Scenario: Successfully fetch already available book by user
    Given user has logged in
    And Book is already available in Library System
    When I ask for a book with book's ID
    Then I get book as result

  Scenario: Unauthorized access to retrieve books
    Given I am not authenticated
    And the book exists in the library system
    When I send a GET all books request to "/api/books"
    Then I should receive 401 response codes

  Scenario: Fetch book with Invalid ID format (non-numeric ID)
    Given I am logged in as a user
    When I send a GET request to "/api/books/abc"
    Then I should receive a 400 response codes

  Scenario: Accessing api with valid user credentials
    Given I am logged in as a user
    And the database contains a book with ID 1
    When I send a GET request to "/api/books/1"
    Then I should receive a 200 response codes

  Scenario: Successfully fetch already available book by admin
    Given I am logged in as an admin
    And Book with ID 1 is already available in Library System
    When I ask for a book with book's ID 1
    Then I get that book as result
      """
      {
        "id": 1,
        "title": "A book",
        "author": "Piruthuvi"
      }
      """