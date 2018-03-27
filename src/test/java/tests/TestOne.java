package tests;

import data.DataProviders;
import drivers.Browser;
import drivers.DriverFactory;
import il.co.topq.difido.model.Enums;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.GoogleMenuPage;

import java.util.Optional;

public class TestOne extends AbstractTestCase {

    private WebDriver driver;

    /**
     * Before every methods setting up
     */
    @BeforeMethod
    public void settingUp() {
        report.log("Setting up the System properties");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        report.log("Getting the driver from the factory");
        Optional<WebDriver> optionalDriver = DriverFactory.getDriver(Browser.CHROME);

        if (optionalDriver.isPresent()) {
            driver = optionalDriver.get();
        }else {
            report.log("Driver does not exist", Enums.Status.failure);
            report.endLevel();
        }

        report.log("Navigate to the Website");
        driver.get("https://www.google.co.il/");

        report.log("Maximized window");
        driver.manage().window().maximize();
    }

    /****
     * First test for google page
     */
    @Test(dataProvider = "data-provider" , dataProviderClass = DataProviders.class)
    public void test(String text) {

        report.log("Creating page Object");
        GoogleMenuPage googleMenuPage = new GoogleMenuPage(driver);

        report.log("Set the input search bar & click on the search button");
        googleMenuPage.setInputSearch("enosh tsur").clickOnSearch();


        Assert.assertEquals(googleMenuPage.getBot().getTitle() , "enosh tsur - חיפוש ב-Google");
        report.log("Succes! title fits" , Enums.Status.success);

        report.log("Data provider:" + text);
    }
}
