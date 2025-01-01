Feature: Create a book
  As an authenticated user
  I want to add a book to the library
  So that it is stored in the library system

  Scenario: Successfully create a book with a id
    Given the user is authenticated with username "user" and password "password"
    When I send a POST request to "/api/books" with:
      """
      {
        "id": 17,
        "title": "Hello world",
        "author": "Sagini"
      }
      """
    Then I should receive a 201 response code
    And the response should contain the same book details:
      """
      {
        "id": 17,
        "title": "Hello world",
        "author": "Sagini"
      }
      """
      
  Scenario: Attempt to create a book with an empty body
    Given I am logged in as an admin
    When I send a POST request to "/api/books" with:
      """
      {}
      """
    Then I should receive a 400 response code

  Scenario: Return 400 response when author is missing in POST request
    Given user is logged In
    When the user sends a POST request with author's value as null
    Then response status code should be 400
