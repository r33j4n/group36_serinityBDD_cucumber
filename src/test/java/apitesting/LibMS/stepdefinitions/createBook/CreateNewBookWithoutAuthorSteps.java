package apitesting.LibMS.stepdefinitions.createBook;

import apitesting.LibMS.models.Book;
import apitesting.LibMS.utils.AuthenticationUtil;
import apitesting.LibMS.utils.BookUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;


import static net.serenitybdd.rest.SerenityRest.then;

public class CreateNewBookWithoutAuthorSteps {
    @Steps
    private BookUtil bookUtil = new BookUtil();
    private String title = "Without Author";
    private Book paramBook = new Book(13,title,null);
    private Book newBook;
    @Given("user is logged In")
    public void user_is_logged_in(){
        AuthenticationUtil.loginAsUser();
    }
    @When("the user sends a POST request with author's value as null")
    public void the_user_sends_a_post_request_with_author_s_value_as_null(){
        this.newBook = bookUtil.postBook(paramBook);
    }
    @Then("response status code should be 400")
    public void response_status_code_should_be_400(){
        then().statusCode(400);
        bookUtil.deleteBook(this.newBook.getId());
    }
}
