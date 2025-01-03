package uitesting.eseatMS.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://sltb.eseat.lk/contactus")
public class ContactUsPageObject extends PageObject {

    @FindBy(id = "name")
    private WebElementFacade NameInput;

    @FindBy(id = "mobile")
    private WebElementFacade MobileNumberInput;

    @FindBy(id = "email")
    private WebElementFacade EmailInput;

    @FindBy(id = "message")
    private WebElementFacade MessageInput;

    @FindBy(id="btnContactUs") // Locates the "Search Buses" button by its CSS classes
    private WebElementFacade SendMessageButton;

    public void typeFromName(String name) {
        NameInput.type(name);
    }
    public void typeFromPhone(String Phone) {
        MobileNumberInput.type(Phone);
    }
    public void typeFromEmail(String Email) {
        EmailInput.type(Email);
    }
    public void typeFromMessage(String Message) {
        MessageInput.type(Message);
    }

    public void clickSendMessageButton(){
        SendMessageButton.click();
    }
}
