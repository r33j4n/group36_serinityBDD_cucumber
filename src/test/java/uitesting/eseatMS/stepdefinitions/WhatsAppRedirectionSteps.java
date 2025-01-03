package uitesting.eseatMS.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import uitesting.eseatMS.actions.HomePageActions;
import uitesting.eseatMS.actions.SendTicketPageActions;

public class WhatsAppRedirectionSteps {
    @Steps
    HomePageActions homePage;

    @Given("I am on the home page")
    public void i_am_on_the_eseat_home_page(){
        homePage.openApplication();
    }

    @When("I click on the WhatsApp icon")
    public void i_click_on_the_whatsapp_icon(){
        homePage.clickWhatsappIcon();
    }

    @Then("I should be redirected to the WhatsApp page")
    public void i_should_be_redirected_to_the_whatsapp_page(){
        String currentUrl = homePage.getCurrentUrl();
        Assert.assertTrue("WhatsApp icon unexpectedly redirected to another page.",
                currentUrl.contains("wa.me"));
    }
}
