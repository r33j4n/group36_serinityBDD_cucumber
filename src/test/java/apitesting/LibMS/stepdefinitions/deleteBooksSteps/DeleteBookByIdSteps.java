package apitesting.LibMS.stepdefinitions.deleteBooksSteps;

import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.When;

public class DeleteBookByIdSteps {

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        ApiRequest.delete(endpoint);
    }

}
