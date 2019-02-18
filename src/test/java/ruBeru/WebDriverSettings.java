package ruBeru;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverSettings {

    public FirefoxDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","/Users/ilichevmikhail/Projects/geckodriver");
        driver = new FirefoxDriver();
    }

//    @AfterMethod
//    public void close() {
//        driver.quit();
//    }
}
