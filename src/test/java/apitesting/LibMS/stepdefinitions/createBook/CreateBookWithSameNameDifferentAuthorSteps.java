package apitesting.LibMS.stepdefinitions.createBook;

import apitesting.LibMS.utils.APIConfig;
import apitesting.LibMS.utils.ApiRequest;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CreateBookWithSameNameDifferentAuthorSteps {
    private static final Logger logger = LoggerFactory.getLogger(CreateBookWithSameNameDifferentAuthorSteps.class);

    @Given("the database already contains a book with ID {int}:")
    public void the_database_already_contains_a_book_with_ID(int id, String bookDetails) {
        ApiRequest.get(APIConfig.ROOT_URI + id);

        if (ApiRequest.response.statusCode() == 404) {
            ApiRequest.post(APIConfig.ROOT_URI,bookDetails);
        } else {
            logger.info("Book with ID {} already exists in the database.", id);
        }
    }

}
