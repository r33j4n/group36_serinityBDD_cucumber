package apitesting.LibMS.stepdefinitions.updateBookNameAuthorSteps;

import apitesting.LibMS.utils.APIConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateBookAndAuthorSteps {
    private static final Logger logger = LoggerFactory.getLogger(UpdateBookAndAuthorSteps.class);
    private Response response;

    @Given("the book exists in the database with ID {int}")
    public void a_book_exists_in_the_database_with_ID(int id) {
        // Ensure the book exists before updating
        response = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.BASE_URI + "/api/books/" + id);

        if (response.statusCode() == 404) {
            // If the book doesn't exist, create it
            String bookDetails = String.format(
                    "{\"id\": %d, \"title\": \"Existing Book Title\", \"author\": \"Original Author\"}", id);
            given()
                    .header("Content-Type", "application/json")
                    .body(bookDetails)
                    .post(APIConfig.BASE_URI + "/api/books");
            logger.info("Book with ID {} created to satisfy precondition.", id);
        }
    }

    @When("I send PUT request to {string} with:")
    public void i_send_a_PUT_request_to_with(String endpoint, String body) {
        logger.info("Sending PUT request to endpoint: {} with body: {}", endpoint, body);
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .put(APIConfig.BASE_URI + endpoint);
        logger.info("Received response: {}", response.getBody().asString());
    }

    @Then("I should receive the {int} response code")
    public void i_should_receive_a_response_code(int expectedStatusCode) {
        logger.info("Validating response status code...");
        logger.info("Expected Status Code: {}, Actual Status Code: {}", expectedStatusCode, response.statusCode());
        assertEquals(expectedStatusCode, response.statusCode(), "Unexpected status code!");
    }
}