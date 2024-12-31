package apitesting.LibMS.stepdefinitions.createBook;

import apitesting.LibMS.models.Book;
import apitesting.LibMS.utils.AuthenticationUtil;
import apitesting.LibMS.utils.BookUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.rest.SerenityRest.then;

public class CreateNewBookWithoutAuthorSteps {
    private BookUtil bookUtil = new BookUtil();
    @Given("user is logged In")
    public void user_is_logged_in(){
        AuthenticationUtil.loginAsAdmin();
    }
    @When("the user sends a POST request with author's value as null")
    public void the_user_sends_a_post_request_with_author_s_value_as_null(){
        Book newBook = new Book(13,"Without Author",null);
        bookUtil.postBook(newBook);
    }
    @Then("response status code should be 400")
    public void response_status_code_should_be_400(){
        then().statusCode(400);
    }
}
