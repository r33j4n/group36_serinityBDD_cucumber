package apitesting.LibMS.stepdefinitions.createBook;

import apitesting.LibMS.models.Book;
import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.AuthenticationUtil;
import apitesting.LibMS.utils.BookUtil;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class CreateBookWithoutTitle {
    Response response;
    BookUtil bookUtil;

    @When("I create a new book request to {string} without title")
    public void i_create_a_new_book_request_to_without_title(String endpoint, String body) {
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(APIConfig.BASE_URI + endpoint);

//        given()
//                .baseUri(APIConfig.BASE_URI)
//                .basePath("/api/books")
//                .body(body)
//                .accept(ContentType.JSON)
//                .contentType(ContentType.JSON).post().getBody().as(Book.class, ObjectMapperType.GSON);
    }

    @Then("Response status code should be 400")
    public void response_status_code_should_be_400() {
        response.then().statusCode(400);
    }
}
