package apitesting.LibMS.stepdefinitions.createBook;

import apitesting.LibMS.utils.APIConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateNewBookSteps {
    private static final Logger logger = LoggerFactory.getLogger(CreateNewBookSteps.class);
    private Response response;
    @Given("the user is authenticated with username {string} and password {string}")
    public void the_user_is_authenticated_with_username_and_password(String username, String password) {
        RestAssured.authentication = RestAssured.basic(username, password);
        logger.info("Authenticated with username: {} and password: {}", username, "********");
    }
    @When("I send a POST request to {string} with:")
    public void i_send_a_POST_request_to_with(String endpoint, String body) {
        logger.info("Sending POST request to endpoint: {} with body: {}", endpoint, body);
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(APIConfig.BASE_URI + endpoint);
        logger.info("Received response: {}", response.getBody().asString());
    }
    @Then("I should receive a {int} response code")
    public void i_should_receive_a_response_code(int expectedStatusCode) {
        logger.info("Validating response status code...");
        logger.info("Expected Status Code: {}, Actual Status Code: {}", expectedStatusCode, response.statusCode());
        assertEquals(expectedStatusCode, response.statusCode(), "Unexpected status code!");
    }

    @Then("the response should contain the same book details:")
    public void the_response_should_contain_the_same_book_details(String expectedResponseBody) {
        logger.info("Validating response body...");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode expectedJson = objectMapper.readTree(expectedResponseBody.trim());
            JsonNode actualJson = objectMapper.readTree(response.getBody().asString().trim());
            String prettyExpected = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(expectedJson);
            String prettyActual = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(actualJson);
            logger.info("Expected Response Body:\n{}", prettyExpected);
            logger.info("Actual Response Body:\n{}", prettyActual);
            assertEquals(prettyExpected, prettyActual, "Response body does not match expected!");
        } catch (Exception e) {
            logger.error("Error parsing or comparing JSON", e);
            throw new RuntimeException("Error validating JSON response", e);
        }
    }
}

