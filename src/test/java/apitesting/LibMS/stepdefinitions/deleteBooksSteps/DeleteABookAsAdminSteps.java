package apitesting.LibMS.stepdefinitions.deleteBooksSteps;

import apitesting.LibMS.utils.APIConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteABookAsAdminSteps {
    private static final Logger logger = LoggerFactory.getLogger(DeleteABookAsAdminSteps.class);
    private Response response;

    @Given("book exists in the database with ID {int}")
    public void aBookExistsInTheDatabase1WithID(int bookId) {
        // Check if the book exists in the database by sending a GET request
        response = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.BASE_URI + "/api/books/" + bookId);

        if (response.statusCode() == 404) {
            throw new RuntimeException("Precondition failed: Book with ID " + bookId + " does not exist.");
        }

        logger.info("Verified book with ID {} exists in the database.", bookId);
    }

    @When("I send a  DELETE request to {string}")
    public void iSendADeleteRequestTo(String endpoint) {
        logger.info("Sending DELETE request to endpoint: {}", endpoint);
        response = given()
                .header("Content-Type", "application/json")
                .delete(APIConfig.BASE_URI + endpoint);

        logger.info("Received response: {}", response.getBody().asString());
    }

    @Then("I  should receive a {int} response code")
    public void iShould1ReceiveAResponseCode(int expectedStatusCode) {
        logger.info("Validating response status code...");
        logger.info("Expected: {}, Actual: {}", expectedStatusCode, response.statusCode());
        assertEquals(expectedStatusCode, response.statusCode(), "Unexpected status code!");
    }
}
