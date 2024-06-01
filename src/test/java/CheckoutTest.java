import helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import checkoutPages.*;

public class CheckoutTest extends BaseTest{
    HomePage searchingForProducts = new HomePage();
    SearchResultsPage selectProductOptions = new SearchResultsPage();
    ProductDetailsPage productDetails = new ProductDetailsPage();
    CheckoutPage checkingOut = new CheckoutPage();
    CartPage cartPage = new CartPage();


    @Test
    public void verifyCheckout() throws InterruptedException {
        //Sreaching for Shoes
        searchingForProducts.searchProduct("Shoes");
        //Opening the product details
        selectProductOptions.selectOptionsForProduct();
        //Selecting size, color and adding to cart
        productDetails.addItemToCart();
        //Navigating back to shop
        productDetails.navigatingBackToShop();

        //Tuka probuvav da skratam so pishuvanje na kod so for loop ama ne mi uspevashe
//        ArrayList<Runnable> categories = new ArrayList<>();
//        categories.add(SearchResultsPage::selectingAccessoriesUnderCategories);
//        categories.add(SearchResultsPage::selectingElectronicsUnderCategories);
//        for (Runnable selectFromCategories : categories) {
//            selectFromCategories.run();
//            selectProductOptions.selectOptionsForProduct();    ==> Tuka mi pagjashe poshto nekoi produkti imaat samo "add to cart" i ne znaev kako da napisham kod za vo toj sluchaj :))
//
//            if (SeleniumHelpers.waitAndFindElement(By.cssSelector("div.msg")).isDisplayed()) {
//                SeleniumHelpers.waitAndFindElement(By.cssSelector("button.continue_shopping")).click();
//            }
//        }

        //Zatoa posebno mi se pishuvani podolu
        //Clicking on accessories (found under categories)
        SearchResultsPage.selectingAccessoriesUnderCategories();
        selectProductOptions.selectOptionsForProduct();
        if (SeleniumHelpers.waitAndFindElement(By.cssSelector("div.msg")).isDisplayed()) {
            SeleniumHelpers.waitForClickableElement(By.cssSelector("button.text-color-dark")).click();
        }

        //Clicking on Men (also found under categories)
        SearchResultsPage.selectingMenUnderCategories();
        selectProductOptions.selectOptionsForProduct();
        productDetails.addItemToCart();

        //Proceeding to "view cart"
        productDetails.clickOnViewCart();

        //Changing added cart items
        cartPage.increaseItemsInCart();
        /*Morav Thread.sleep, nikako ne mi go izvrshuvashe sledniot metod poshto stranata dolgo vreme mi se loadira otkako ke stisne "Update Cart" :(
        Se vnesuvashe brojot 4 vo poleto ama otkako ke se loadira stranata mi se vrakjashe na brojot 1, i zatoa staviv Thread za da poceka malce*/
        Thread.sleep(3000);
        cartPage.changeQuantityOfItem("4");

        //Pak mnorav poshto dolgo vreme loadira posle kopcheto "update cart" i nikako ne uspevam da napravam da klikne "place order"
        Thread.sleep(2000);

        //Proceeding to checkout
        cartPage.proceedToCheckout();

        //Filling in billing details
        checkingOut.addBillingDetails("First Name", "Last Name", "Address", "City", "95880", "1212312", "email@email.com");

        //Placing order
        checkingOut.placingOrder();

        //Verifying checkout
        String actualMsg = checkingOut.verifyOrder().getText();
        String expectedMsg = "Thank you. Your order has been received.";
        Assert.assertEquals(actualMsg, expectedMsg);

    }



}
