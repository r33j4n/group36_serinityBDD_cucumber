package apitesting.LibMS.stepdefinitions.createBook;

import apitesting.LibMS.models.Book;
import apitesting.LibMS.utils.BookUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.then;

public class CreateNewBookWithoutIDSteps {
    private String title = "Without ID";
    private String author = "Without ID's author";
    Book newBook =new Book(title,author);
    @Steps
    BookUtil bookUtil = new BookUtil();
    @When("the user sends a POST request with id's value as null")
    public void the_user_sends_a_post_request_with_id_s_value_as_null(){
        bookUtil.postBook(newBook);
    }
    @Then("response status code should be 201")
    public void response_status_code_should_be_201(){
        then().statusCode(201);
        then().body("title", Matchers.equalTo(title));
        then().body("author", Matchers.equalTo(author));
    }
}
