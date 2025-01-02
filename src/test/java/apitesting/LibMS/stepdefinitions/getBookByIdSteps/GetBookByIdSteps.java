package apitesting.LibMS.stepdefinitions.getBookByIdSteps;


import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetBookByIdSteps {

    private static final Logger logger = LoggerFactory.getLogger(GetBookByIdSteps.class);

    @Given("the database does not contain a book with ID {int}")
    public void the_database_does_not_contain_a_book_with_ID(int id) {
        ApiRequest.get("/api/books/" + id);

        if (ApiRequest.response.statusCode() != 404) {
            ApiRequest.delete("/api/books/" + id);
        }
    }

    @When("I send a GET request to {string}")
    public void i_send_a_GET_request_to(String endpoint) {
        ApiRequest.get(endpoint);
    }
    @Then("I should receive a {int} response codes")
    public void i_should_receive_a_response_code(int expectedStatusCode) {
        logger.info("Validating response status code...");
        logger.info("Expected Status Code: {}, Actual Status Code: {}", expectedStatusCode, ApiRequest.response.statusCode());
        assertEquals(expectedStatusCode, ApiRequest.response.statusCode(), "Unexpected status code!");
    }



}