package apitesting.LibMS.stepdefinitions.getBookByIdSteps;

import apitesting.LibMS.models.Book;
import apitesting.LibMS.utils.APIConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetBookWithID1 {
    private Response response;
    @Given("Book with ID {int} is already available in Library System")
    public void book_with_id_is_already_available_in_library_system(int id) {
        response = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.PUT_URI + id);

        if (response.statusCode() == 404) {
            Book book = new Book(1, "A book", "Piruthuvi");
            // If the book not exists, it should be created to satisfy the precondition.
            response = given()
                    .header("Content-Type", "application/json")
                    .body(book.toString())
                    .post(APIConfig.POST_URI);
        }
    }
    @When("I ask for a book with book's ID {int}")
    public void i_ask_for_a_book_with_book_s_id(int id) {
        response = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.PUT_URI + id);
    }
    @Then("I get that book as result")
    public void i_get_that_book_as_result(String expectedResponseBody) {
        assertEquals(expectedResponseBody, response.getBody().asString());
    }
}