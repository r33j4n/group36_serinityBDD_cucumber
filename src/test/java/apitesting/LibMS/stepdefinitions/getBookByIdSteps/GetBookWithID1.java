package apitesting.LibMS.stepdefinitions.getBookByIdSteps;

import apitesting.LibMS.models.Book;
import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetBookWithID1 {

    private Response response;


    @Given("Book with ID {int} is already available in Library System")
    public void book_with_id_is_already_available_in_library_system(int id) {
        response = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.BASE_URI + "/api/books/" + id);

        if (response.statusCode() == 404) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            Book book = new Book(id, "A book", "Piruthuvi");
            // If the book not exists, it should be created to satisfy the precondition.
            response = given()
                    .header("Content-Type", "application/json")
                    .body(book.toString())
                    .post(APIConfig.BASE_URI + "/api/books");
        }
    }

    @When("I ask for a book with book's ID {int}")
    public void i_ask_for_a_book_with_book_s_id(int id) {
        response = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.BASE_URI + "/api/books/" + id);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" + response.getBody().asString());
    }

    @Then("I get that book as result")
    public void i_get_that_book_as_result(String expectedResponseBody) {
        assertEquals(200, response.statusCode());
        assertEquals(expectedResponseBody, response.getBody().asString());
    }


}