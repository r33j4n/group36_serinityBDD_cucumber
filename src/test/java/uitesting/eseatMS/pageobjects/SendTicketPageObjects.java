package uitesting.eseatMS.pageobjects;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

public class SendTicketPageObjects extends PageObject {
    public void sendTicketPageVerified(){
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://sltb.eseat.lk/ticket/send-view");
    }
}
