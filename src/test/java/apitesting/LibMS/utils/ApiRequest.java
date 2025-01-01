package apitesting.LibMS.utils;


import apitesting.LibMS.stepdefinitions.getBookByIdSteps.GetBookByIdSteps;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class
ApiRequest {

    private static final Logger logger = LoggerFactory.getLogger(GetBookByIdSteps.class);

    private static Response sendRequest(String method, String endpoint, String body){
        logger.info("Sending {} request to endpoint: {} with body: {}", method.toUpperCase(), endpoint, body);
        Response response = given()
                .header("Content-Type","application/json")
                .body(body != null ? body : "")
                .request(method.toUpperCase(), APIConfig.BASE_URI + endpoint);
        logger.info("Received response: {}", response.getBody().asString());
        return response;
    }

    public static Response get(String endpoint) {
        return sendRequest("GET", endpoint, null);
    }

    public static Response post(String endpoint, String body){
        return sendRequest("POST", endpoint, body);
    }


    public static Response put(String endpoint, String body){
        return sendRequest("PUT", endpoint, body);

    }

}
