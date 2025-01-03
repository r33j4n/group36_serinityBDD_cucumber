package apitesting.LibMS.stepdefinitions.getBookByIdSteps;

import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.ApiRequest;
import apitesting.LibMS.utils.AuthenticationUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import java.util.List;
import java.util.Map;

public class GetAllBooksSteps {
    @Given("User is logged in")
    public void user_is_logged_in() {
        AuthenticationUtil.loginAsUser();
    }
    @And("The database does not contain any books")
    public void the_database_does_not_contain_any_books() {
        ApiRequest.get(APIConfig.ROOT_URI);
        JsonPath jsonPath = ApiRequest.response.jsonPath();
        List<Map<String, Object>> books = jsonPath.getList("$");

        for (Map<String, Object> book : books) {
            System.out.println("________________________book__________________"+book.get("title"));
            ApiRequest.delete(APIConfig.ROOT_URI + book.get("id"));
        }
    }
    @When("I ask for all books")
    public void i_ask_for_all_books() {
        ApiRequest.get(APIConfig.ROOT_URI);
    }
    @Then("I should get empty array with 200 status code")
    public void i_should_get_empty_array_with_200_status() {
        ApiRequest.response.then().statusCode(200);
    }
}
