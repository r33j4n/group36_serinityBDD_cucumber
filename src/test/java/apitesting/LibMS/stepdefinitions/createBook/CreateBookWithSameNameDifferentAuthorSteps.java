package apitesting.LibMS.stepdefinitions.createBook;

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
public class CreateBookWithSameNameDifferentAuthorSteps {
    private static final Logger logger = LoggerFactory.getLogger(CreateBookWithSameNameDifferentAuthorSteps.class);

    @Given("the database already contains a book with ID {int}:")
    public void the_database_already_contains_a_book_with_ID(int id, String bookDetails) {
        ApiRequest.get("/api/books/" + id);

        if (ApiRequest.response.statusCode() == 404) {
            ApiRequest.post("/api/books",bookDetails);
        } else {
            logger.info("Book with ID {} already exists in the database.", id);
        }
    }

    @When("I send  a POST request to {string} with:")
    public void i_send_a_POST_request_to_with(String endpoint, String body) {
        ApiRequest.post(endpoint,body);
    }

    @Then("I should receive  {int} response code")
    public void i_should_receive_a_response_code(int expectedStatusCode) {
        logger.info("Validating response status code...");
        logger.info("Expected Status Code: {}, Actual Status Code: {}", expectedStatusCode, ApiRequest.response.statusCode());
        assertEquals(expectedStatusCode, ApiRequest.response.statusCode(), "Unexpected status code!");
    }

}
