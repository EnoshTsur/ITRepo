package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/***
 * First Page of Google test
 */
public class GoogleMenuPage extends AbstractPage {

    // Google attributes
    private final static By SEARCH_BAR = By.id("lst-ib");
    private final static By BTN = By.name("btnK");


    /***
     * CTR contains Driver

     * @param driver
     */
    public GoogleMenuPage(WebDriver driver) {
        super(driver);
    }

    /***
     * Setting input text
     * @param text
     * @return GoogleMenuPage for flow
     */
    public GoogleMenuPage setInputSearch(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SEARCH_BAR)));
        bot.sendKeys(SEARCH_BAR, text);
        return this;
    }

    /***
     * Clicking on search button
     * @return GoogleMenuPage for flow
     */
    public GoogleMenuPage clickOnSearch(){
        bot.scrollPage();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BTN)));
        bot.clickOn(BTN);
        return this;
    }




}
