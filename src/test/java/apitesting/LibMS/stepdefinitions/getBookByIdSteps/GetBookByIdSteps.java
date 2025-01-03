package apitesting.LibMS.stepdefinitions.getBookByIdSteps;


import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.ApiRequest;
import apitesting.LibMS.utils.ProvideNonExistBookID;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class GetBookByIdSteps {
    public static List<Integer> existingBookIds;
    public static int nonExistingBookId;
    public static Response response;
    @Given("the database does not contain a book with ID {int}")
    public void the_database_does_not_contain_a_book_with_ID(int id) {
        ApiRequest.get(APIConfig.ROOT_URI + id);

        if (ApiRequest.response.statusCode() != 404) {
            ApiRequest.delete(APIConfig.ROOT_URI + id);
        }
    }

    @When("I send a GET request with non existing Book Id")
    public void iSendAGETRequestWithNonExistingBookId() {
        ProvideNonExistBookID.nonExistingBookId = nonExistingBookId;
        String fullUrl = APIConfig.POST_URI + "/" + nonExistingBookId;
        ApiRequest.response = RestAssured.given().get(fullUrl);
    }
}