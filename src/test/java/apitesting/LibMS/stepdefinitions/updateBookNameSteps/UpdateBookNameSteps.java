package apitesting.LibMS.stepdefinitions.updateBookNameSteps;

import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateBookNameSteps {
    private static final Logger logger = LoggerFactory.getLogger(UpdateBookNameSteps.class);

    @Given("the database contains a book with ID {int}")
    public void the_database_contains_a_book_with_ID(int id) {
        ApiRequest.get("/api/books/" + id);

        if (ApiRequest.response.statusCode() == 404) {
            throw new RuntimeException("Precondition failed: Book with ID " + id + " does not exist in the database.");
        }

        logger.info("Verified book with ID {} exists in the database.", id);
    }

    @When("I send a PUT request  to {string} with:")
    public void i_send_a_PUT_request_to_with(String endpoint, String body) {
        logger.info("Sending PUT request to endpoint: {} with body: {}", endpoint, body);
        ApiRequest.put(endpoint, body);
        logger.info("Received response: {}", ApiRequest.response.getBody().asString());
    }

}