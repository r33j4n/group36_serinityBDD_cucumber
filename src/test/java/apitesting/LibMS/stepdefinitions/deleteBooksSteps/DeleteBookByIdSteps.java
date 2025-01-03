package apitesting.LibMS.stepdefinitions.deleteBooksSteps;

import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteBookByIdSteps {

    private static final Logger logger = LoggerFactory.getLogger(DeleteBookByIdSteps.class);

    @When("I send a DELETE request to {string}")
    public void iSendADELETERequestTo(String endpoint) {
        ApiRequest.delete(endpoint);
    }

}
