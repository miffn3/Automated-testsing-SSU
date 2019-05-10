package ruBeru;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class SupportSettings {

    public static EventFiringWebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/ilyichev/IdeaProjects/webdrivertngs/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        EventListener eventListener = new EventListener();
        driver.register(eventListener);
        driver.get("https://beru.ru");

    }

    @AfterMethod
    public void close() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver);
        if(pageObjectMain.checkLoggedIn()){
            pageObjectMain.clickButtonAccount();
            pageObjectMain.clickButtonLogOut();
        }
        driver.quit();
    }

    @DataProvider(name = "ChangeCity")
    public static Object[][] citiesNames() {
        Object[][] returnArray = {new Object[] {"Балаково"}, new Object[] {"Хвалынск"}};
        return returnArray;
    }
}
