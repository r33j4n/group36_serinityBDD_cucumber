Feature: Create a book
  As an authenticated user
  I want to add a book to the library
  So that it is stored in the library system

  Scenario: Successfully create a book with a id
    Given I am logged in as a user
    When I send a POST request to "/api/books" with:
      """
      {
        "id": 17,
        "title": "Playing it my Way",
        "author": "Thareejan"
      }
      """
    Then I should receive a 201 response code
    And the response should contain the same book details:
      """
      {
        "id": 17,
        "title": "Playing it my Way",
        "author": "Thareejan"
      }
      """
  Scenario: Attempt to create book without author
    Given user is logged In
    When the user sends a POST request with author's value as null
    Then response status code should be 400

  Scenario: Attempt to create book without ID
    Given user is logged In
    When the user sends a POST request with id's value as null
    Then response status code should be 201

  Scenario: Attempt to create a book with an empty body
    Given I am logged in as an admin
    When I send a POST request to "/api/books" with:
    """
    {}
    """
    Then I should receive a 400 response code

  Scenario: Create book without title
    Given I am logged in as a user
    When I send a POST request to "/api/books" with:
    """
    {
      "id": 160,
      "author": "Piruthuvi"
    }
    """
    Then I should receive a 400 response code

  Scenario: Attempt to create a book with the same name but a different author
    Given I am logged in as a user
    And I send a POST request to "/api/books" with:
      """
      {
        "id": 1,
        "title": "Test Book",
        "author": "Varaki"
      }
      """
    When I send a POST request to "/api/books" with:
      """
      {
        "id": 1,
        "title": "Test Book",
        "author": "Vakeesan V."
      }
      """
    Then I should receive a 201 response code

  Scenario: Create book with ID only
    Given User is logged in
    When I create a new book request to "/api/books" with ID only
    """
    {
      "id": 160
    }
    """
    Then Response status code must be 400
