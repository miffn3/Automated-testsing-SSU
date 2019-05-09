package ruBeru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class PageObjectToothbrushesSection {

    private WebDriver driver;
    private WebElement priceFieldMin;
    private WebElement priceFieldMax;
    private WebElement countToothbrush;
    private WebElement cart;
    private List<WebElement> toothbrushes;

    public PageObjectToothbrushesSection(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter minimum price")
    public void enterPriceMin() {
        priceFieldMin = driver.findElement(By.name("Цена от"));
        priceFieldMin.sendKeys("999");
    }

    @Step("Enter maximum price")
    public void enterPriceMax() {
        priceFieldMax = driver.findElement(By.name("Цена до"));
        priceFieldMax.sendKeys("1999");
    }

    @Step("Check count of toothbrushes")
    public void checkToothbrushCount() {
        driver.navigate().refresh();
        countToothbrush = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("_160zXyZIMr")));
        Assert.assertNotEquals(countToothbrush.getAttribute("textContent"), "0");
    }

    @Step("Add toothbrush to cart")
    public void addToothbrush() {
        toothbrushes = driver.findElements(By.cssSelector(".l3daMzINHn>button"));
        while (!toothbrushes.get(toothbrushes.size() - 2).getAttribute("textContent").equals("В корзине")) {
            toothbrushes.get(toothbrushes.size() - 2).click();
            break;
        }
    }

    @Step("Click go to cart button")
    public void clickButtonGoToCart() {
        cart = driver.findElement(By.xpath("//span[contains(@class, '_2w0qPDYwej')"
                + " and contains(text(), 'В корзине')]"));
        cart.click();
    }
}
