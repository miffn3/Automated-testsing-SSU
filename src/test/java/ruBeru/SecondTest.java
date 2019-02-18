package ruBeru;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest extends WebDriverSettings {

    @Test
    public void secondTest() {
        driver.get("https://beru.ru/");

        //Смена города на "Хвалынск"
        driver.findElement(By.cssSelector("._1ZYDKa22GJ > div:nth-child(1) > svg:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".region-form-opener > span:nth-child(1)")).click();
        driver.findElement(By.cssSelector("span.input__box:nth-child(2)")).click();
        driver.findElement(By.name("value")).sendKeys("Хвалынск");
        driver.findElement(By.cssSelector("span.input__box:nth-child(2)")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("button.button2:nth-child(3)")).click();

        //Главная страница
        driver.findElement(By.className("header2-nav-item__text")).click();

        //Страница ввода логина
        driver.findElement(By.className("passp-form-field__input")).click();
        driver.findElement(By.name("login")).sendKeys("miffn1@yandex.ru");
        driver.findElement(By.cssSelector("div.passp-button:nth-child(12)")).click();

        //Страница ввода пароля
        driver.findElement(By.name("passwd")).sendKeys("webDriverIlichev19");
        driver.findElement(By.cssSelector(".passp-button")).click();
        }

}
