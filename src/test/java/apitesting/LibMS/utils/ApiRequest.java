package apitesting.LibMS.utils;


import apitesting.LibMS.stepdefinitions.getBookByIdSteps.GetBookByIdSteps;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class ApiRequest {
    public static Response response;

    private static final Logger logger = LoggerFactory.getLogger(GetBookByIdSteps.class);

    private static void sendRequest(String method, String endpoint, String body){
        logger.info("Sending {} request to endpoint: {} with body: {}", method.toUpperCase(), endpoint, body);
        response = given()
                .header("Content-Type","application/json")
                .body(body != null ? body : "")
                .request(method.toUpperCase(), APIConfig.BASE_URI + endpoint);
        logger.info("Received response: {}", response.getBody().asString());

    }

    public static void get(String endpoint) {
        sendRequest("GET", endpoint, null);
    }

    public static void post(String endpoint, String body){
        sendRequest("POST", endpoint, body);
    }


    public static void put(String endpoint, String body){
        sendRequest("PUT", endpoint, body);

    }

    public static void delete(String endpoint){
        sendRequest("DELETE", endpoint,null);
    }

}
