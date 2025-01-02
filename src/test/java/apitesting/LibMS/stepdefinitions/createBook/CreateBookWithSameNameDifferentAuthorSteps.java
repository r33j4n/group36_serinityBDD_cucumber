package apitesting.LibMS.stepdefinitions.createBook;

import apitesting.LibMS.utils.APIConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CreateBookWithSameNameDifferentAuthorSteps {
    private static final Logger logger = LoggerFactory.getLogger(CreateBookWithSameNameDifferentAuthorSteps.class);
    private Response response;

    @Given("the database already contains a book with ID {int}:")
    public void the_database_already_contains_a_book_with_ID(int id, String bookDetails) {
        // Check if the book exists in the database
        response = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.BASE_URI + "/api/books/" + id);

        if (response.statusCode() == 404) {
            // If the book doesn't exist, create it using the provided book details
            given()
                    .header("Content-Type", "application/json")
                    .body(bookDetails)
                    .post(APIConfig.BASE_URI + "/api/books");
            logger.info("Book with ID {} created in the database to meet the precondition.", id);
        } else {
            logger.info("Book with ID {} already exists in the database.", id);
        }
    }

    @When("I send  a POST request to {string} with:")
    public void i_send_a_POST_request_to_with(String endpoint, String body) {
        logger.info("Sending POST request to endpoint: {} with body: {}", endpoint, body);
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(APIConfig.BASE_URI + endpoint);
        logger.info("Received response: {}", response.getBody().asString());
    }

    @Then("I should receive  {int} response code")
    public void i_should_receive_a_response_code(int expectedStatusCode) {
        logger.info("Validating response status code...");
        logger.info("Expected Status Code: {}, Actual Status Code: {}", expectedStatusCode, response.statusCode());
        assertEquals(expectedStatusCode, response.statusCode(), "Unexpected status code!");
    }

}
