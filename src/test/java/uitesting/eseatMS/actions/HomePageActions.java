package uitesting.eseatMS.actions;

import net.serenitybdd.annotations.Step;
import uitesting.eseatMS.pageobjects.HomePageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class HomePageActions {
    HomePageObjects homePageObjects;

    @Step
    public void openApplication() {
        homePageObjects.open();
    }

    @Step
    public void clickSendTicketButton() {
        homePageObjects.clickSendTicket();
    }

    @Step
    public void navigateTimetablePage() {
        homePageObjects.clickSearchBusTimetableButton();
    }

    @Step
    public void clickContactUsButton(){
        homePageObjects.clickContactUs();
    }

    @Step
    public void clickWhatsappIcon(){
        homePageObjects.clickWhatsappIcon();
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    @Step
    public void clickSearchBusesButton(){
        homePageObjects.clickSearchBusesButton();
    }

    @Step
    public void enterFromLocation(String fromLocation) {
        homePageObjects.typeFromLocation(fromLocation);
    }

    @Step
    public void enterToLocation(String toLocation) {
        homePageObjects.typeToLocation(toLocation);
    }

    @Step
    public void enterTravelDate(String date) {
        if (date.equalsIgnoreCase("today")) {
            LocalDate today = LocalDate.now();
            date = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        homePageObjects.enterTravelDate(date);
    }
}
