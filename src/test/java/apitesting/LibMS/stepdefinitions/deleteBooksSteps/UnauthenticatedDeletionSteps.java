package apitesting.LibMS.stepdefinitions.deleteBooksSteps;

import apitesting.LibMS.utils.AuthenticationUtil;
import apitesting.LibMS.utils.BookUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.then;

public class UnauthenticatedDeletionSteps {
    @Steps
    BookUtil bookUtil = new BookUtil();
    @Given("unauthorized login attempt")
    public void unauthorized_login_attempt(){
        AuthenticationUtil.noAuthentication();
    }
    @When("send delete request with ID {int}")
    public void send_delete_request_with_id(Integer id){
        bookUtil.deleteBook(id);
    }
    @Then("the status code should be 401")
    public void the_status_code_should_be_401(){
        then().statusCode(401);
    }
}
