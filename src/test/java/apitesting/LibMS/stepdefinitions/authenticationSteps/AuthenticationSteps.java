package apitesting.LibMS.stepdefinitions.authenticationSteps;

import apitesting.LibMS.utils.AuthenticationUtil;
import io.cucumber.java.en.Given;

public class AuthenticationSteps {
    @Given("I am logged in as a user")
    public void i_am_logged_in_as_a_user() {
        AuthenticationUtil.loginAsUser();
    }

    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
        AuthenticationUtil.loginAsAdmin();
    }

    @Given("I am not authenticated")
    public void not_authenticated() {
        AuthenticationUtil.noAuthentication();
        System.out.println("Authentication cleared. No credentials will be provided");
    }
}