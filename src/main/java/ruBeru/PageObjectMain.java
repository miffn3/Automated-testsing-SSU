package ruBeru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PageObjectMain {

    private WebDriver driver;
    private WebElement logInButton;
    private WebElement logOutButton;
    private WebElement accountButton;
    private WebElement cityButton;
    private WebElement cityName;
    private WebElement settingsButton;
    private WebElement catalogButton;
    private WebElement hygieneSection;
    private WebElement toothbrushesSection;

    public PageObjectMain(WebDriver webDriver) {
        driver = webDriver;
    }


    @Step("Click login button")
    public void clickButtonLogin() {
        logInButton = driver.findElement(By.className("header2-nav-item__text"));
        logInButton.click();
    }

    @Step("Check text in account window")
    public void checkText() {
        accountButton = driver.findElement(By.className("header2-nav__user"));
        String text = accountButton.getText();
        Assert.assertTrue(text.equals("Мой профиль"));
    }

    @Step("Click change city button")
    public void clickButtonChangeCity() {
        cityButton = driver.findElement(By.xpath("//div[contains(@class, 'unique-selling-proposition-line__region')]" +
                "//span[contains(@class, 'link__inner')]"));
        cityButton.click();
    }

    @Step("Check city")
    public void checkCity(String cityName) {
        this.cityName = driver.findElement(By.cssSelector(".link__inner"));
        Assert.assertTrue(this.cityName.getAttribute("textContent").equals(cityName));
    }

    @Step("Click account button")
    public void clickButtonAccount() {
        accountButton = driver.findElement(By.className("header2-nav-item__text"));
        accountButton.click();
    }

    @Step("Click settings button")
    public void clickButtonSettings() {
        settingsButton = driver.findElement(By.xpath("//a[text() = 'Настройки']"));
        settingsButton.click();
    }

    @Step("Click catalog button")
    public void clickButtonCatalog() {
        catalogButton = driver.findElement(By.cssSelector("button._popup2-destructor"));
        catalogButton.click();
    }

    @Step("Move to hygiene section")
    public void moveToSectionHygiene() {
        hygieneSection = driver
                .findElement(By.cssSelector("a.n-navigation-vertical-category__link:nth-child(10) " +
                        "> span:nth-child(1)"));
        Actions action = new Actions(driver);
        action.moveToElement(hygieneSection).build().perform();
    }

    @Step("Click toothbrushes section")
    public void clickSectionToothbrushes() {
        toothbrushesSection = driver.findElement(By.xpath("//a[text() = 'Электрические зубные щетки']"));
        toothbrushesSection.click();
    }

    @Step("Log out")
    public void clickButtonLogOut() {
        logOutButton = driver.findElement(By.xpath("//a[text() = 'Выход']"));
        logOutButton.click();
    }


    public boolean checkLoggedIn() {
        accountButton = driver.findElement(By.className("header2-nav__user"));
        String accountText = accountButton.getText();
        return accountText.equals("Мой профиль");
    }
}
