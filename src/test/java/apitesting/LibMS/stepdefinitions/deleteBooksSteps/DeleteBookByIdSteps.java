package apitesting.LibMS.stepdefinitions.deleteBooksSteps;

import apitesting.LibMS.stepdefinitions.getBookByIdSteps.GetBookByIdSteps;
import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteBookByIdSteps {

    private static final Logger logger = LoggerFactory.getLogger(GetBookByIdSteps.class);
    @When("I send a DELETE request to {string}")
    public void iSendADELETERequestTo(String endpoint) {
        ApiRequest.delete(endpoint);
    }

    @Then("I should receive {int} status code")
    public void iShouldReceiveStatusCode(int expectedStatusCode) {
        logger.info("Validating response status code.....");
        logger.info("Expected Status Code: {}, Actual Status Code: {}", expectedStatusCode, ApiRequest.response.statusCode());
        assertEquals(expectedStatusCode, ApiRequest.response.statusCode(), "Unexpected status code!");
    }
}
