package apitesting.LibMS.stepdefinitions.deleteBooksSteps;

import apitesting.LibMS.stepdefinitions.getBookByIdSteps.GetBookByIdSteps;
import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteBookByIdSteps {

    private static final Logger logger = LoggerFactory.getLogger(GetBookByIdSteps.class);
    private Response response;
    @When("I send a DELETE request to {string}")
    public void iSendADELETERequestTo(String endpoint) {
        logger.info("Sending requets to delete a book");
        response = given()
                .header("Content-Type", "application/json")
                .delete(APIConfig.BASE_URI + endpoint);

    }

    @Then("I should receive {int} status code")
    public void iShouldReceiveStatusCode(int expectedStatusCode) {
        logger.info("Validating response status code.....");
        logger.info("Expected Status Code: {}, Actual Status Code: {}", expectedStatusCode, response.statusCode());
        assertEquals(expectedStatusCode, response.statusCode(), "Unexpected status code!");
    }
}
