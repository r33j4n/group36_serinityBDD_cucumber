package uitesting.eseatMS.actions;

import net.serenitybdd.annotations.Step;
import uitesting.eseatMS.pageobjects.SendTicketPageObjects;

public class SendTicketPageActions {
    SendTicketPageObjects sendTicket;
    @Step
    public void verify(){
        sendTicket.sendTicketPageVerified();
    }
}
