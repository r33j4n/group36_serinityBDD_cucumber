package uitesting.eseatMS.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uitesting.eseatMS.actions.ContactUsActions;
import uitesting.eseatMS.actions.HomePageActions;

import java.time.Duration;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ContactUsFormSteps {
    @Steps
    HomePageActions homePage;
    ContactUsActions contactUsActions;

    @Given("I am  on the home page")
    public void i_am_on_the_home_page() {
        homePage.openApplication();
    }

    @Given("I am on the contact page")
    public void i_am_on_the_contact_page() {
        contactUsActions.openApplication();
    }

    @And("I click Contact Us Button")
    public void i_click_contact_us_button(){
        getDriver().findElement(By.linkText("Contact Us")).click();
//        homePage.clickContactUsButton();
        // Optionally, wait for the Contact Us page to load
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://sltb.eseat.lk/contactus"));
    }

    @When("I fill out the contact us form with Name: {string} email address: {string} Mobile Number: {string} and Message: {string}")
    public void i_fill_out_the_contact_us_form_with_valid_details(String Name, String Email, String Mobile, String Message) {
        contactUsActions.enterName(Name);
        contactUsActions.enterPhone(Mobile);
        contactUsActions.enterEmail(Email);
        contactUsActions.enterMessage(Message);
    }

    @And("I submit the form")
    public void i_submit_the_form() {
        contactUsActions.clickSendButton();
    }

    @Then("I should see the success message {string}")
    public void i_should_see_the_success_message(String expectedMessage) {
        // Locate the success message using the class 'alert alert-success'
        String actualMessage = getDriver().findElement(By.cssSelector("div.alert.alert-success")).getText();

        // Assert that the actual message contains the expected message
        Assert.assertTrue(
                "Expected success message was not displayed.",
                actualMessage.contains(expectedMessage)
        );

    }
}
