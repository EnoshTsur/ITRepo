package page;

import bot.ActionBot;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * An abstract class that make a definition for pages
 */
public abstract class AbstractPage {

    // Page attributes
    protected WebDriver driver;
    protected ActionBot bot;
    protected WebDriverWait wait;

    /***
     * CTR contains Driver
     * @param driver
     */
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
        this.wait = new WebDriverWait(driver ,30);
    }

    /***
     * Getter for ActionBot
     * @return ActionBot bot
     */
    public ActionBot getBot() {
        return this.bot;
    }
}
