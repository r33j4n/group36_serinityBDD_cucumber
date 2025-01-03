package apitesting.LibMS.stepdefinitions.getBookByIdSteps;

import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class GetBookWithIDSteps {
    private Response response;
    @When("I ask for a book with book's ID")
    public void i_ask_for_a_book_with_book_s_id() {
        Integer bookId = ApiRequest.response.jsonPath().getInt("id");
        ApiRequest.get(APIConfig.ROOT_URI+bookId);
    }
}