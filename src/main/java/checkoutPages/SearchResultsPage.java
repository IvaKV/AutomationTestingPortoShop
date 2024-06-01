package checkoutPages;

import helpers.SeleniumHelpers;
import org.openqa.selenium.By;

public class SearchResultsPage {
    private final By productCard = By.cssSelector("div.tb-hover-content");
    private final By selectOptions = By.xpath("//a[@title='Select options']");
    private final By addToCartBtn = By.xpath("//a[@title='Add to cart']");
    static final By accessoriesBtn = By.linkText("Accessories");
    static final By menBtn = By.linkText("Men");

    //Some of the products have the "select options" button that takes you to the product page
    public void selectOptionsForProduct () {
        SeleniumHelpers.hover(productCard);

        if (SeleniumHelpers.findElement(addToCartBtn).isDisplayed()) {
            SeleniumHelpers.waitAndLocateElement(addToCartBtn).click();
        } else {
            SeleniumHelpers.waitAndFindElement(selectOptions).click();
        }
    }


    public static void selectingAccessoriesUnderCategories () {
        SeleniumHelpers.findElement(accessoriesBtn).click();
    }

    public static void selectingMenUnderCategories() {
        SeleniumHelpers.findElement(menBtn).click();

    }

}
