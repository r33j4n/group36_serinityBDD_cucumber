Feature: Update Book
  As an admin
  I want to update the author name of an existing book
  So that the changes are reflected in the library system

  As an admin
  I want to update the author name of an existing book
  So that the changes are reflected in the library system

  Scenario: Successfully update the book author name
    Given I am logged in as an admin
    And a book exists in the database with ID 1
    When I send a PUT request to "/api/books/1" with:
      """
      {
        "id": 1,
        "title": "Existing Book Title",
        "author": "Updated Author"
      }
      """
    Then I should receive a 200 response  code
    And the response should contain the updated book details:
      """
      {
        "id": 1,
        "title": "Existing Book Title",
        "author": "Updated Author"
      }
      """