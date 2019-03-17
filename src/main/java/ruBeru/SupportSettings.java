package ruBeru;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class SupportSettings extends HighlighterClass{

    public ChromeDriver driver;

    public void open() {

        //Открытие сайта
        driver.get("https://beru.ru/");
        //Закрытие рекламы
        driver.findElement(By.cssSelector("._1ZYDKa22GJ > div:nth-child(1) > svg:nth-child(1)")).click();

    }

    public void login() {

        //Главная страница
        highlighterMethod(driver, driver.findElement(By.className("header2-nav-item__text")));
        driver.findElement(By.className("header2-nav-item__text")).click();

        //Страница ввода логина
        highlighterMethod(driver, driver.findElement(By.className("passp-form-field__input")));
        driver.findElement(By.className("passp-form-field__input")).click();
        driver.findElement(By.name("login")).sendKeys("miffn1@yandex.ru");
        driver.findElement(By.cssSelector("div.passp-button:nth-child(12)")).click();

        //Страница ввода пароля
        highlighterMethod(driver, driver.findElement(By.name("passwd")));
        driver.findElement(By.name("passwd")).sendKeys("webDriverIlichev19");
        highlighterMethod(driver, driver.findElement(By.cssSelector(".passp-button")));
        driver.findElement(By.cssSelector(".passp-button")).click();

    }

    public void logout(){

        highlighterMethod(driver,driver.findElement(By.className("header2-nav-item__text")));
        driver.findElement(By.className("header2-nav-item__text")).click();
        highlighterMethod(driver,driver.findElement(By.xpath("//a[text() = 'Выход']")));
        driver.findElement(By.xpath("//a[text() = 'Выход']")).click();

    }

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/ilyichev/IdeaProjects/webdrivertngs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @AfterMethod
    public void close() {

        driver.quit();

    }
}
