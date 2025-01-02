package apitesting.LibMS.stepdefinitions.deleteBooksSteps;

import apitesting.LibMS.models.Book;
import apitesting.LibMS.utils.AuthenticationUtil;
import apitesting.LibMS.utils.BookUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.then;

public class UnauthorizedDeletionByUserSteps {
    private Integer id = 2;
    private String title = "Unauthorized Delete Attempt";
    private String author = "user";
    private Book paramBook = new Book(id,title,author);
    @Steps
    private BookUtil bookUtil = new BookUtil();
    private Book newBook;
    @Given("user logged in")
    public void user_logged_in(){
        AuthenticationUtil.loginAsUser();
    }
    @And("book is already available")
    public void book_is_already_available(){
        newBook = bookUtil.postBook(paramBook);
    }
    @When("user sends delete request with valid ID")
    public void user_sends_delete_request_with_valid_id(){
        bookUtil.deleteBook(newBook.getId());
    }
    @Then("the status code should be 403")
    public void the_status_code_should_be_403(){
        then().statusCode(403);
    }
}
