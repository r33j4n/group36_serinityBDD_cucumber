package uitesting.eseatMS.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

public class BusSearchResultsPage extends PageObject {

    public void verifySearchBusPage(){
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://sltb.eseat.lk/search?type=1&from=Colombo&to=Jaffna&from_date=2025-01-30&to_date=");
    }
}
