package checkoutPages;

import helpers.SeleniumHelpers;
import org.openqa.selenium.By;

public class CartPage {
    private final By quantityPlusBtn = By.className("plus");
    private final By quantityNumberField = By.cssSelector("tbody tr:nth-of-type(3) .input-text");
    private final By updateCartBtn = By.name("update_cart");
    private final By proceedToCheckoutBtn = By.className("btn-v-dark");


    //Clicking on the + button to increase quantity of the item in the cart and updating the cart (prices to be recalculated)
    public void increaseItemsInCart () {
        SeleniumHelpers.findElement(quantityPlusBtn).click();
        SeleniumHelpers.waitForClickableElement(updateCartBtn).click();
    }

    //Erasing the number of the items (removing the item from cart using just the number between + and -)
    public void changeQuantityOfItem (String quantity) {
        SeleniumHelpers.waitAndFindElement(quantityNumberField).clear();
        SeleniumHelpers.findElement(quantityNumberField).sendKeys(quantity);
        SeleniumHelpers.waitForClickableElement(updateCartBtn).click();
    }

    public void proceedToCheckout () {
        SeleniumHelpers.findElement(proceedToCheckoutBtn).click();
    }
}
