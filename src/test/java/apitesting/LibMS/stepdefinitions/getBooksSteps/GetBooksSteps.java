package apitesting.LibMS.stepdefinitions.getBooksSteps;

import apitesting.LibMS.stepdefinitions.createBook.CreateNewBookSteps;
import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetBooksSteps{
    private static final Logger logger = LoggerFactory.getLogger(CreateNewBookSteps.class);

    @Given("I use invalid credentials with username {string} and password {string}")
    public void i_use_invalid_credentials_with_username_and_password(String username, String password) {
        logger.info("Sending invalid username: {} and password: {}", username, password);
        RestAssured.authentication = RestAssured.basic(username, password);
    }

    @When("I send a GET request to {string} endpoint")
    public void i_send_a_get_request_to_endpoint(String endpoint) {
        ApiRequest.get(endpoint);
    }


}
