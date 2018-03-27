package bot;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


/***
 * Action bot for website test actions
 */
public class ActionBot {

    private WebDriver driver;
    private Actions action;

    /***
     * CTR contains driver
     * @param driver
     */
    public ActionBot(WebDriver driver){
        this.driver = driver;
        this.action = new Actions(driver);
    }

    /***
     * Get page title - for Assert
     * @return String - title
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /***
     * Navigate to website
     * @param url
     * @return Action Bot for flow
     */
    public ActionBot navigate(String url){
        driver.get(url);
        return this;
    }

    /***
     * Clicking on element
     * @param locator
     * @return Action Bot for flow
     */
    public ActionBot clickOn(By locator) {
        driver.findElement(locator).click();
        return  this;
    }

    /***
     * Send keys
     * @param locator
     * @param keys
     * @return Action Bot for flow
     */
    public ActionBot sendKeys(By locator , String keys) {
        driver.findElement(locator).sendKeys(keys);
        return this;
    }

    /***
     * Sending keyBoard keys
     * @param locator
     * @param keys
     * @return Action Bot for flow
     */
    public ActionBot sendKeyboardKeys(By locator , Keys keys) {
        action.sendKeys(driver.findElement(locator), keys).perform();
        return this;
    }
}
