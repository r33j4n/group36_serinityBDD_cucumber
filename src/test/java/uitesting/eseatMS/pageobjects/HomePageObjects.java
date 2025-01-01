package uitesting.eseatMS.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://sltb.eseat.lk/home")
public class HomePageObjects extends PageObject {
    public void clickSendTicket(){
        $(By.linkText("Send Ticket")).click();
    }
}
