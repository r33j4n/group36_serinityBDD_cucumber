package apitesting.LibMS.stepdefinitions.getBookByIdSteps;

import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.AuthenticationUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UnauthorizedGetBookByID {
    private Response response;
    @Given("no credentials")
    public void no_credentials(){
        AuthenticationUtil.noAuthentication();
    }
    @When("send GET book request with ID {int}")
    public void send_get_book_request_with_id(Integer id){
        response = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.BASE_URI + "/api/books/"+id);
    }
    @Then("should receive 401")
    public void should_receive_401(){
        response.then().statusCode(401);
    }
}
