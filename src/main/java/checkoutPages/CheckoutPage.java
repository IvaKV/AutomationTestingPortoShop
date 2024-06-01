package checkoutPages;

import helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    private final By firstNameField = By.id("billing_first_name");
    private final By lastNameField = By.id("billing_last_name");
    private final By countryField = By.id("billing_country");
    private final By billingAddressField = By.id("billing_address_1");
    private final By cityField = By.id("billing_city");
    private final By postCodeField = By.id("billing_postcode");
    private final By phoneField = By.id("billing_phone");
    private final By emailField = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By orderCompletedMsg = By.cssSelector("p.woocommerce-thankyou-order-received");

    public void addBillingDetails (String firstName, String lastName, String address, String city, String postCode, String phone, String email) {
        SeleniumHelpers.findElement(firstNameField).sendKeys(firstName);
        SeleniumHelpers.findElement(lastNameField).sendKeys(lastName);

        WebElement countryFieldDropDown = SeleniumHelpers.findElement(countryField);
        Select selectCountryDropDown = new Select(countryFieldDropDown);
        selectCountryDropDown.selectByValue("FR");

        SeleniumHelpers.findElement(billingAddressField).sendKeys(address);
        SeleniumHelpers.findElement(cityField).sendKeys(city);
        SeleniumHelpers.findElement(postCodeField).sendKeys(postCode);
        SeleniumHelpers.findElement(phoneField).sendKeys(phone);
        SeleniumHelpers.findElement(emailField).sendKeys(email);
    }

    public void placingOrder () {
        SeleniumHelpers.waitForClickableElement(placeOrderBtn).click();
    }

    public WebElement verifyOrder () {
        return SeleniumHelpers.waitAndFindElement(orderCompletedMsg);
    }



}
