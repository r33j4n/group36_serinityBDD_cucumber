package apitesting.LibMS.stepdefinitions.createBook;

import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;

public class CreateNewBookWithoutIDSteps {
    @Then("I should receive a {int} response code with title as {string} and author as {string}")
    public void i_should_receive_a_response_code_with_title_as_and_author_as(int statusCode, String title, String author){
        ApiRequest.response.then().statusCode(statusCode);
        ApiRequest.response.then().body("title", Matchers.equalTo(title));
        ApiRequest.response.then().body("author", Matchers.equalTo(author));
    }
}
