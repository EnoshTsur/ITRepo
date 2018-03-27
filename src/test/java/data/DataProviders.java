package data;
import org.testng.annotations.DataProvider;

/***
 * Data providers
 */
public class DataProviders {

    /***
     * Data Provider
     * @return 2D Object
     */
    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        return DataReader.getObjectFromData().get();
    }
}
