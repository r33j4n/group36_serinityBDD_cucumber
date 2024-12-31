package apitesting.LibMS.stepdefinitions.getBookByIdSteps;

import apitesting.LibMS.models.Book;
import apitesting.LibMS.utils.BookUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.then;

public class GetAlreadyAvailableBookByIdSteps {
    private Book newBook;
    private Book paramBook = new Book(1,"Kity","author");
    @Steps
    private BookUtil bookUtil = new BookUtil();

    @Given("Book is already available in Library System")
    public void book_is_already_available_in_library_system() {
        newBook = bookUtil.postBook(paramBook);
    }

    @When("I ask for a book with book's ID")
    public void i_ask_for_a_book_with_book_s_id() {
        bookUtil.getBook(newBook.getId());
    }

    @Then("I get book as result")
    public void i_get_book_as_result() {
        then().body("title", Matchers.equalTo(paramBook.getTitle()));
        then().body("author", Matchers.equalTo(paramBook.getAuthor()));
    }
}