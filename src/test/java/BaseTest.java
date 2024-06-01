import helpers.SeleniumHelpers;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import checkoutPages.HomePage;

public class BaseTest  implements ITestNGListener {
    HomePage homePage = new HomePage();
    @BeforeSuite
    public void setUp () {
        SeleniumHelpers.initializeWebDriver();
        SeleniumHelpers.getDriver().get("https://www.portotheme.com/wordpress/porto/shop4-soft/");
        SeleniumHelpers.getDriver().manage().window().maximize();
        homePage.closeCommercialPopUp();
    }

    @AfterSuite
    public void tearDown () {
        SeleniumHelpers.getDriver().quit();
    }
}
