package apitesting.LibMS.stepdefinitions.getBookByIdSteps;


import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetBookByIdSteps  {

    private static final Logger logger = LoggerFactory.getLogger(GetBookByIdSteps.class);


    @Given("the database does not contain a book with ID {int}")
    public void the_database_does_not_contain_a_book_with_ID(int id) {
        ApiRequest.get("/api/books/" + id);

        if (ApiRequest.response.statusCode() != 404) {
            // If the book exists, it should be deleted to satisfy the precondition.
            ApiRequest.delete("/api/books/" + id);
            logger.info("Book with ID {} removed from the database to satisfy precondition.", id);
        }
    }

    @When("I send a GET request to {string}")
    public void i_send_a_GET_request_to(String endpoint) {
        logger.info("Sending GET request to endpoint: {}", endpoint);
        ApiRequest.get(endpoint);
        logger.info("Received response: {}", ApiRequest.response.getBody().asString());
    }



}