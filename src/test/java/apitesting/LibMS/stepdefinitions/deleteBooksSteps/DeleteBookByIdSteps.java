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
    @When("I send a DELETE request to {string}")
    public void iSendADELETERequestTo(String endpoint) {
        ApiRequest.delete(endpoint);
    }

}
