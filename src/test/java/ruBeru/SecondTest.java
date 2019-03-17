package ruBeru;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SecondTest extends SupportSettings {

    @Parameters("cityName")
    @Test
    public void secondTest(String cityName) {

        //Открытие сайта
        open();

        //Смена города на "city-name"

        driver.findElement(By.xpath("//div[contains(@class, 'unique-selling-proposition-line__region')]" +
                        "//span[contains(@class, 'link__inner')]")).click();
        driver.findElement(By.xpath("(//form[contains(@class,'region-select-form')]//input)[1]"))
                .sendKeys(cityName, Keys.ENTER);
        driver.findElement(By.xpath("//form[contains(@class, 'region-select-form')]" +
                "//div[contains(@class, 'region-suggest__list-item')]")).click();
        driver.findElement(By.xpath("//form[contains(@class, 'region-select-form')]//button")).click();
        driver.navigate().refresh();
        WebElement city = driver.findElement(By.cssSelector(".link__inner"));
        System.out.println(city.getAttribute("textContent"));
        Assert.assertTrue(city.getAttribute("textContent").equals(cityName));

        //Авторизация
        login();

        //Переходим в настройки и сравниваем город доставки
        driver.findElement(By.className("header2-nav-item__text")).click();
        driver.findElement(By.xpath("//a[text() = 'Настройки']")).click();
        String corner = driver.findElement(By.xpath("//div[contains(@class,'header2__main')]" +
                "//span[contains(@class, 'link__inner')]")).getText();
        driver.get("https://beru.ru/my/settings#region");
        String profile = driver.findElement(By.xpath("//div[contains(@class,'n-headline')]" +
                "//span[contains(@class, 'link__inner')]")).getText();
        Assert.assertTrue(corner.equals(profile));

        //Возвращение в исходное состояние
        logout();
        }

}
