package uitesting.eseatMS.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import uitesting.eseatMS.pageobjects.ContactUsPageObject;
import uitesting.eseatMS.pageobjects.HomePageObjects;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ContactUsActions extends UIInteractionSteps {
    HomePageObjects homePageObjects;
    ContactUsPageObject contactUsPageObject;

    @Step
    public void openApplication(){
        getDriver().get("https://sltb.eseat.lk/contactus");
    }

    @Step
    public void enterName(String Name) {
        contactUsPageObject.typeFromName(Name);
    }

    @Step
    public void enterEmail(String Email) {
        contactUsPageObject.typeFromEmail(Email);
    }

    @Step
    public void enterPhone(String Phone) {
        contactUsPageObject.typeFromPhone(Phone);
    }

    @Step
    public void enterMessage(String Message) {
        contactUsPageObject.typeFromMessage(Message);
    }

    @Step
    public void clickSendButton(){
        contactUsPageObject.clickSendMessageButton();



    }

}
