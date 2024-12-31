package uitesting.eseatMS.actions;

import net.serenitybdd.annotations.Step;
import uitesting.eseatMS.pageobjects.HomePageObjects;

public class HomePageActions {
    HomePageObjects homePageObjects;
    @Step
    public void openApplication(){
        homePageObjects.open();
    }
    @Step
    public void clickSendTicketButton(){
        homePageObjects.clickSendTicket();
    }
}
