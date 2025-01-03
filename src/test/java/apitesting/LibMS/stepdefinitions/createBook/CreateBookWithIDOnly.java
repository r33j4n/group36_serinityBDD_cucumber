package apitesting.LibMS.stepdefinitions.createBook;

import apitesting.LibMS.utils.APIConfig;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateBookWithIDOnly {
    Response response;

    @When("I create a new book request to {string} with ID only")
    public void i_create_a_new_book_request_to_with_id_only(String endpoint, String body) {
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(APIConfig.BASE_URI + endpoint);
    }

    @Then("Response status code must be 400")
    public void response_status_must_should_be_400() {
        response.then().statusCode(400);
        assertEquals(400, response.statusCode());
    }
}
