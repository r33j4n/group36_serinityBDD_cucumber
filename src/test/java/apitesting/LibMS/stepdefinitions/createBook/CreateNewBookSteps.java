package apitesting.LibMS.stepdefinitions.createBook;

import apitesting.LibMS.models.Book;
import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.ApiRequest;
import apitesting.LibMS.utils.AuthenticationUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateNewBookSteps {
    private static final Logger logger = LoggerFactory.getLogger(CreateNewBookSteps.class);
    Response response;
    public static List<Integer> createdBooksIDs = new ArrayList<>();

    @When("I send a POST request to {string} with:")
    public void i_send_a_POST_request_to_with(String endpoint, String body) {
        ApiRequest.post(endpoint, body);
        this.response = ApiRequest.response;

        if (ApiRequest.response.statusCode() == 201) {
            int createdBookId = ApiRequest.response.jsonPath().getInt("id");
            createdBooksIDs.add(createdBookId);
            logger.info("Book created with ID: {}", createdBookId);
        } else {
            System.err.println("POST request failed. Status Code: " + ApiRequest.response.statusCode());
        }
    }

    @Then("I should receive a {int} response code")
    public void i_should_receive_a_response_code(int expectedStatusCode) {
        logger.info("Expected Status Code: {}, Actual Status Code: {}", expectedStatusCode, ApiRequest.response.statusCode());
        assertEquals(expectedStatusCode, ApiRequest.response.statusCode(), "Unexpected status code!");
    }

    @Then("the response should contain the same book details:")
    public void the_response_should_contain_the_same_book_details(String expectedResponseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Book expectedResponse = objectMapper.readValue(expectedResponseBody,Book.class);
            Book actualResponse = ApiRequest.response.getBody().as(Book.class, ObjectMapperType.GSON);

            logger.info("Expected Response Body:\n{}", expectedResponse.toString());
            logger.info("Actual Response Body:\n{}", actualResponse.toString());

            assertEquals(expectedResponse, actualResponse, "Response body does not match expected!");
        } catch (Exception e) {
            logger.error("Error parsing or comparing JSON", e);
            throw new RuntimeException("Error validating JSON response", e);
        }
    }

    @AfterAll
    public static void after_all() {
        AuthenticationUtil.loginAsUser();
        logger.info("Deleting all created books...");
        for (int bookId : createdBooksIDs) {
            String deleteEndpoint = APIConfig.ROOT_URI + bookId;
            ApiRequest.delete(deleteEndpoint);
            logger.info("Deleted book with ID: {}", bookId);
        }
        createdBooksIDs.clear();
    }
}