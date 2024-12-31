package apitesting.LibMS.utils;


import apitesting.LibMS.stepdefinitions.getBookByIdSteps.GetBookByIdSteps;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class ApiRequest {

    private static final Logger logger = LoggerFactory.getLogger(GetBookByIdSteps.class);

    public static Response get(String endpoint) {
        logger.info("Sending GET request to endpoint: {}", endpoint);
        Response response = given()
                .header("Content-Type", "application/json")
                .get(APIConfig.BASE_URI + endpoint);
        logger.info("Received response: {}", response.getBody().asString());
        return response;
    }

    public static void post(String endpoint, String body){
        logger.info("Sending POST request to endpoint: {} with body: {}", endpoint, body);
        Response response;
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(APIConfig.BASE_URI + endpoint);
        logger.info("Received response: {}", response.getBody().asString());
    }

    public static void put(String endpoint, String body){
        logger.info("Sending PUT request to endpoint: {} with body: {}", endpoint, body);
        Response response;
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .put(APIConfig.BASE_URI + endpoint);
        logger.info("Received response: {}", response.getBody().asString());

    }

}
