Feature: Fetching all books
  As an authenticated user
  I want to fetch all the books
  So that I can see all the books exist in library

  Scenario: Accessing getAllBooks api with invalid credentials
    Given I use invalid credentials with username "invalidUser" and password "invalidPass"
    When I send a GET request to "/api/books/" endpoint
    Then I should receive a 401 response code

  Scenario: Database have no books
    Given User is logged in
    And I ask for all books
    When The database does not contain any books
    Then I should get empty array with 200 status code
