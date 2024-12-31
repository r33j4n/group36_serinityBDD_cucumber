package apitesting.LibMS.utils;

import io.restassured.RestAssured;

public class AuthenticationUtil {

    public static void loginAsAdmin() {
        RestAssured.authentication = RestAssured.basic("admin", "password");
    }

    public static void loginAsUser() {
        RestAssured.authentication = RestAssured.basic("user", "password");
    }
}