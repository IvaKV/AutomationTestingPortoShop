package checkoutPages;

import helpers.SeleniumHelpers;
import org.openqa.selenium.By;

public class ProductDetailsPage extends SearchResultsPage {
    private final By addToCart = By.className("single_add_to_cart_button");
    private final By cartBtn = By.className("cart-head");
    private final By viewCartBtn = By.xpath("//*[@id=\"mini-cart\"]/div[2]/div/div/a");
    private final By selectColor = By.cssSelector("a[class^=filter]");
    private final By selectSize = By.cssSelector("ul[data-name$=size] a.enabled");
    private final By shopBtn = By.xpath("/html/body/div[1]/section/div/div/div/div[2]/ul/li[2]/a");

    public void addItemToCart () {
        if (SeleniumHelpers.waitAndFindElement(selectColor).isDisplayed()) {
            SeleniumHelpers.waitAndFindElement(selectColor).click();
        }
        if (SeleniumHelpers.waitForClickableElement(selectSize).isEnabled()) {
            SeleniumHelpers.waitAndFindElement(selectSize).click();
        }
        SeleniumHelpers.waitAndFindElement(addToCart).click();
    }

    public void navigatingBackToShop () {
        SeleniumHelpers.findElement(shopBtn).click();
    }

    public void clickOnViewCart () {
        SeleniumHelpers.hover(cartBtn);
        SeleniumHelpers.waitForClickableElement(viewCartBtn).click();
    }
}
