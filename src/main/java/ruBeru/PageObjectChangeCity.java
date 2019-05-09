package ruBeru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectChangeCity {

    private WebDriver driver;
    private WebElement fieldNameCity;
    private WebElement suggestedCity;
    private WebElement enterButtonCity;

    public PageObjectChangeCity(WebDriver webDriver) {
        this.driver = webDriver;
    }

    @Step("Enter the city")
    public void enterCity(String cityName) {
        fieldNameCity = driver.findElement(By.xpath("(//form[contains(@class,'region-select-form')]//input)[1]"));
        fieldNameCity.sendKeys(cityName, Keys.ENTER);
    }

    @Step("Click suggest city")
    public void clickSuggestedCity() {
        suggestedCity = driver.findElement(By.xpath("//form[contains(@class, 'region-select-form')]" +
                "//div[contains(@class, 'region-suggest__list-item')]"));
        suggestedCity.click();
    }

    @Step("Admit the  city")
    public void clickEnterButtonCity() {
        enterButtonCity =  driver.findElement(By.xpath("//form[contains(@class, 'region-select-form')]//button"));
        enterButtonCity.click();
        driver.navigate().refresh();
    }
}
