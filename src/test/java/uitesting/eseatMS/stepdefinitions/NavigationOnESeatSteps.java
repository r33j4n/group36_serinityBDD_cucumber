package uitesting.eseatMS.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import uitesting.eseatMS.actions.HomePageActions;
import uitesting.eseatMS.actions.SendTicketPageActions;

public class NavigationOnESeatSteps {
    @Steps
    HomePageActions homePage;
    @Steps
    SendTicketPageActions sendTicket;
    @Given("I am on the eseat home page")
    public void i_am_on_the_eseat_home_page(){
        homePage.openApplication();
    }
    @When("I click send ticket button")
    public void i_click_send_ticket_button(){
        homePage.clickSendTicketButton();
    }
    @Then("I should be navigated to send ticket page")
    public void i_should_be_navigated_to_send_ticket_page(){
        sendTicket.verify();
    }
}
