package uitesting.eseatMS.actions;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import uitesting.eseatMS.pageobjects.BusTimetablePageObjects;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BusTimetablePageActions {
    BusTimetablePageObjects busTimetablePageObjects;

    @Step
    public void enterFromLocation(String fromLocation) {
        busTimetablePageObjects.typeFromLocation(fromLocation);
    }

    @Step
    public void enterToLocation(String toLocation) {
        busTimetablePageObjects.typeToLocation(toLocation);
    }

    @Step
    public void enterStartTime(String startTime) {
        busTimetablePageObjects.typeStartTimeInput(startTime);
    }

    @Step
    public void enterEndTime(String endTime) {
        busTimetablePageObjects.typeEndTimeInput(endTime);
    }

    @Step
    public void clickSearchButton() {
        busTimetablePageObjects.clickSearchBusTimetableButton();
    }

    public void verifyBusTimetablePage(){
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://sltb.eseat.lk/bus/schedule/search?from=39&to=11&start=06%3A00&end=12%3A00&bus_type=any");
    }
}
