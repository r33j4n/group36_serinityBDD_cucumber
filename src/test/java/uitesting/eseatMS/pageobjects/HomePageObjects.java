package uitesting.eseatMS.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://sltb.eseat.lk/home")
public class HomePageObjects extends PageObject {

    @FindBy(id = "from")
    private WebElementFacade fromLocationInput;

    @FindBy(id = "to")
    private WebElementFacade toLocationInput;

    @FindBy(id ="from_date")
    private WebElementFacade travelDateInput;

    @FindBy(css = "button.btn.btn-success.btn-bus-main.full-width") // Locates the "Search Buses" button by its CSS classes
    private WebElementFacade searchBusesButton;

    public void clickSendTicket(){
        $(By.linkText("Send Ticket")).click();
    }

    public void clickWhatsappIcon(){
        $(By.cssSelector("a img[src*='whatsapp.png']")).click();
    }

    public void typeFromLocation(String location) {
        fromLocationInput.type(location);
    }

    public void typeToLocation(String location) {
        toLocationInput.type(location);
    }
    public void enterTravelDate(String date) {
        travelDateInput.clear();
        travelDateInput.type(date);
    }

    public void clickSearchBusesButton(){
        searchBusesButton.click();
    }
}
