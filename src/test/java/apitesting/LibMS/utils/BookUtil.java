package apitesting.LibMS.utils;

import apitesting.LibMS.models.Book;
import io.cucumber.java.After;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.given;


public class BookUtil {
    private Book newBook;
    private static final List<Integer> books = new ArrayList<>();
    @Step
    public Book postBook(Book book){
         this.newBook = given()
                .baseUri(APIConfig.BASE_URI)
                .basePath("/api/books")
                .body(book)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post().getBody().as(Book.class, ObjectMapperType.GSON);
         if(!books.contains(newBook.getId())){
             books.add(newBook.getId());
         }
        return this.newBook;
    }
    @Step
    public void getBook(Integer id){
        given()
                .baseUri(APIConfig.BASE_URI)
                .basePath("/api/books")
                .when()
                .get("/" + id);
    }
    @Step
    public void deleteBook(Integer id){
        given()
                .baseUri(APIConfig.BASE_URI)
                .basePath("/api/books")
                .delete("/"+id );
    }
    @After
    public void cleanUpBooks(){
        if(!books.isEmpty()){
            AuthenticationUtil.loginAsUser();
            for(Integer book: books){
                given()
                        .baseUri(APIConfig.BASE_URI)
                        .basePath("/api/books")
                        .delete("/"+book.intValue());
            }
        }

    }
}
