package apitesting.LibMS.stepdefinitions.getBookByIdSteps;

import apitesting.LibMS.utils.APIConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetBooksWithUnauthorizedAccess {

    private static final Logger logger = LoggerFactory.getLogger(GetBooksWithUnauthorizedAccess.class);
    private Response response;

    @Given("the book exists in the library system")
    public void bookIsAlreadyAvailableInLibrarySystem() {
        logger.info("Verifying a book exists in the library system...");
        Response getResponse = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.BASE_URI + "/api/books/1");

        if (getResponse.statusCode() == 404) {
            throw new RuntimeException("No books available in the library system.");
        }
        logger.info("Verified a book exists in the library system.");
    }

    @When("I send a GET all books request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        logger.info("Sending GET request to endpoint: {}", endpoint);
        response = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.BASE_URI + endpoint);
        logger.info("Received response: {}", response.getBody().asString());
    }

    @Then("I should receive {int} response codes")
    public void iShouldReceiveAResponseCode(int expectedStatusCode) {
        logger.info("Validating response status code...");
        assertEquals(expectedStatusCode, response.getStatusCode(), "Unexpected response status code!");
    }
}