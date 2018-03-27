package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/***
 * Factory for different types of WebDrivers
 */
public class DriverFactory {


    /***
     * Get Optional<WebDriver> by Browser
     * @param browser
     * @return Optional<WebDriver>
     */
    public static Optional<WebDriver> getDriver(Browser browser) {
        Optional<WebDriver> driver;

        switch (browser) {
            case CHROME:
              driver = Optional.of(new ChromeDriver());
              driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
              return driver;
            case FIREFOX:
                driver = Optional.of(new FirefoxDriver());
                driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                return driver;
            case EDGE:
                driver = Optional.of(new EdgeDriver());
                driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                return driver;
                default:
                    driver = Optional.ofNullable(null);
                    return driver;
        }
    }
}
