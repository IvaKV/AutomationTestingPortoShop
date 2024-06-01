package checkoutPages;

import helpers.SeleniumHelpers;
import org.openqa.selenium.By;

public class HomePage {
    private final By commercialPopUpCloseBtn = By.className("mfp-close");
    private final By searchBtn = By.className("btn-special");
    private final By searchField = By.name("s");


    //Searching for product and clicking the search button
    public void searchProduct (String product){
        SeleniumHelpers.findElement(searchField).sendKeys(product);
        SeleniumHelpers.findElement(searchBtn).click();
    }

    //The commercial that pops up at any time
    public void closeCommercialPopUp () {
        boolean commercialPopUpIsDisplayed = SeleniumHelpers.waitAndFindElement(commercialPopUpCloseBtn).isDisplayed();
        if (commercialPopUpIsDisplayed)
            SeleniumHelpers.waitAndFindElement(commercialPopUpCloseBtn).click();
    }
}
