package uitesting.eseatMS.pageobjects;

import net.thucydides.core.pages.PageObject;

public class SendTicketPageObjects extends PageObject {
    public void sendTicketPageVerified(){
        System.out.println(getDriver().getTitle());
    }
}
