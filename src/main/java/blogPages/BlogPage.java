package blogPages;

import helpers.SeleniumHelpers;
import org.openqa.selenium.By;

public class BlogPage {

    private final By blogBtn = By.linkText("Blog");
    private final By blogPost = By.cssSelector("h4.porto-heading");

    private final By commentField = By.id("comment");
    private final By nameField = By.id("author");
    private final By emailField = By.id("email");
    private final By websiteField = By.id("url");
    private final By submitBtn = By.id("submit");
    private final By commentModeration = By.tagName("em");


    public void navigateToBlog () {
        SeleniumHelpers.findElement(blogBtn).click();
    }

    public void clickOnABlog () {
        SeleniumHelpers.findElement(blogPost).click();
    }

    public void postAComment (String comment, String name, String email, String website) {
        SeleniumHelpers.findElement(commentField).sendKeys(comment);
        SeleniumHelpers.findElement(nameField).sendKeys(name);
        SeleniumHelpers.findElement(emailField).sendKeys(email);
        SeleniumHelpers.findElement(websiteField).sendKeys(website);
        SeleniumHelpers.findElement(submitBtn).click();
    }

    public String getName () {
        return SeleniumHelpers.waitAndLocateElement(commentModeration).getText();
    }

}
