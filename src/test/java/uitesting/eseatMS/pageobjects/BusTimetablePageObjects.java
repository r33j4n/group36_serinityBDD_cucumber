package uitesting.eseatMS.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@DefaultUrl("https://sltb.eseat.lk/bus/schedules")
public class BusTimetablePageObjects extends PageObject {

    @FindBy(className = "select2-search__field")
    private WebElementFacade locationInputs;

    @FindBy(id = "select2-from-container")
    private WebElementFacade fromLocationInput;

    @FindBy(id = "select2-to-container")
    private WebElementFacade toLocationInput;

    @FindBy(name = "start")
    private WebElementFacade startTimeInput;

    @FindBy(name = "end")
    private WebElementFacade endTimeInput;

    @FindBy(css = "button.btn.btn-success.btn-bus-main.full-width.float-left")
    private WebElementFacade searchTimetableButton;

    @FindBy(className = "select2-results__option--highlighted")
    private WebElementFacade dropDownElements;

    public void typeFromLocation(String location) {

        fromLocationInput.click();
        fromLocationInput.waitUntilPresent();
        locationInputs.type(location);
        dropDownElements.click();
    }

    public void typeToLocation(String location) {
        toLocationInput.click();
        toLocationInput.waitUntilPresent();
        locationInputs.type(location);
        dropDownElements.click();
    }

    public void typeStartTimeInput(String start) {
        startTimeInput.click();
        Select select = new Select(startTimeInput);
        select.selectByValue(start);
    }

    public void typeEndTimeInput(String end) {
        endTimeInput.click();
        Select select = new Select(endTimeInput);
        select.selectByValue(end);
    }

    public void clickSearchBusTimetableButton() {
        searchTimetableButton.click();
    }


}
