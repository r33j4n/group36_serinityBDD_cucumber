package apitesting.LibMS.utils;

import apitesting.LibMS.models.Book;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class BookUtil {
    @Step
    public Book postBook(Book book){
        Book newBook = given()
                .baseUri(APIConfig.BASE_URI)
                .basePath("/api/books")
                .body(book, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post().getBody().as(Book.class, ObjectMapperType.GSON);
        return newBook;
    }

    @Step
    public void getBook(Integer id){
        given()
                .baseUri(APIConfig.BASE_URI)
                .basePath("/api/books")
                .when()
                .get("/" + id)
                .then()
                .statusCode(200);
    }
}
