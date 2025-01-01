Feature: Fetching all books
  As an authenticated user
  I want to fetch all the books
  So that I can see all the books exist in library

  Scenario: Accessing getAllBooks api with invalid credentials
    Given I use invalid credentials with username "invalidUser" and password "invalidPass"
    When I send a GET request to "/api/books/" endpoint
    Then the response code should be 401

