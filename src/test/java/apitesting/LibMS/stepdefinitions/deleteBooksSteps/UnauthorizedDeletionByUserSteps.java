package apitesting.LibMS.stepdefinitions.deleteBooksSteps;

import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class UnauthorizedDeletionByUserSteps {
    @And("book is already available")
    public void book_is_already_available(String body){
        ApiRequest.post(APIConfig.ROOT_URI, body);
    }
    @When("I send delete request with valid ID")
    public void i_send_delete_request_with_valid_id(){
        Integer bookId = ApiRequest.response.jsonPath().getInt("id");
        ApiRequest.delete(APIConfig.ROOT_URI+bookId);
    }
}
