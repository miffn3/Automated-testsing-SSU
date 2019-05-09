package ruBeru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PageObjectSettings {

    private WebDriver driver;
    private WebElement cornerCityName;
    private WebElement settingsCityName;

    public PageObjectSettings(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check changed city int the settings")
    public void checkChangedCity() {
        cornerCityName = driver.findElement(By.xpath("//div[contains(@class,'header2__main')]" +
                "//span[contains(@class, 'link__inner')]"));
        String cornerName = cornerCityName.getText();
        driver.get("https://beru.ru/my/settings#region");
        settingsCityName = driver.findElement(By.xpath("//div[contains(@class,'n-headline')]" +
                "//span[contains(@class, 'link__inner')]"));
        String settingsName = settingsCityName.getText();
        Assert.assertTrue(cornerName.equals(settingsName));
    }
}
