package uitesting.eseatMS.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import uitesting.eseatMS.actions.BusSearchResultsPageActions;
import uitesting.eseatMS.actions.HomePageActions;

public class SearchForBusesSteps {

    @Steps
    HomePageActions homePageActions;

    @Steps
    BusSearchResultsPageActions busSearchResultsPageActions;

    @When("I enter from location as {string} and to location as {string}")
    public void iEnterFromLocationAsAndToLocationAs(String fromLocation, String toLocation) {
        homePageActions.enterFromLocation(fromLocation);
        homePageActions.enterToLocation(toLocation);

    }

    @And("I enter {string} as the travel on data")
    public void iEnterAsTheTravelOnData(String date) {
        homePageActions.enterTravelDate(date);
    }

    @And("I click the search buses button")
    public void iClickTheSearchBusesButton() {
        homePageActions.clickSearchBusesButton();

    }

    @Then("I should be navigated to bus Search results page")
    public void iShouldBeNavigatedToBusSearchResultsPage() {
        busSearchResultsPageActions.verifyNavigationToResultsPage();
    }


}
