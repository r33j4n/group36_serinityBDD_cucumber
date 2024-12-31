package apitesting.LibMS.base;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APIValidator {
    private static final Logger logger = LoggerFactory.getLogger(APIValidator.class);

    public static void validateAPIHealth() {
        logger.info("Checking API health...");
        int statusCode = RestAssured.given()
                .get("/api/books")
                .statusCode();
        if (statusCode != 200) {
            throw new IllegalStateException("API is not healthy. Status code: " + statusCode);
        }
        logger.info("API is healthy.");
    }
}