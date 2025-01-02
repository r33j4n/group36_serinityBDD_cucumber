package uitesting.eseatMS.actions;

import net.serenitybdd.annotations.Step;
import uitesting.eseatMS.pageobjects.BusSearchResultsPage;

public class BusSearchResultsPageActions {

    BusSearchResultsPage busSearchResultsPage;

    @Step
    public void verifyNavigationToResultsPage(){
        busSearchResultsPage.verifySearchBusPage();
    }
}
