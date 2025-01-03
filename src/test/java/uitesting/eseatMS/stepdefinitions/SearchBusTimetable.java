package uitesting.eseatMS.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import uitesting.eseatMS.actions.BusTimetablePageActions;
import uitesting.eseatMS.actions.HomePageActions;


public class SearchBusTimetable {

    @Steps
    BusTimetablePageActions busTimetablePageActions;

    @Steps
    HomePageActions homePageActions;

    @And("I click the BUS TIME TABLE button")
    public void iClickTheBusTimeTableButton() {
        homePageActions.navigateTimetablePage();
    }

    @When("I enter from location as {string}")
    public void iEnterFromLocationAs(String fromLocation) {
        busTimetablePageActions.enterFromLocation(fromLocation);

    }

    @When("I enter to location as {string}")
    public void iEnterToLocationAs(String toLocation) {
        busTimetablePageActions.enterToLocation(toLocation);

    }

    @And("I enter start time as {string}")
    public void iEnterStartTimeAs(String startTime) {
        busTimetablePageActions.enterStartTime(startTime);

    }

    @And("I enter end time as {string}")
    public void iEnterEndTimeAs(String endTime) {
        busTimetablePageActions.enterEndTime(endTime);

    }

    @And("I click the search button")
    public void iClickTheSearchButton() {
        busTimetablePageActions.clickSearchButton();
    }

    @Then("I should be navigated to bus timetable results page")
    public void iShouldBeNavigatedToBusTimetableResultsPage() {
        busTimetablePageActions.verifyBusTimetablePage();
    }


}
