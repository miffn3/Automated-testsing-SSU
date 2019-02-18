package ruBeru;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTest extends WebDriverSettings{

    @Test
    public void firstTest() {
        driver.get("https://beru.ru/");

        //Главная страница
        driver.findElement(By.cssSelector("._1ZYDKa22GJ > div:nth-child(1) > svg:nth-child(1)")).click();
        driver.findElement(By.className("header2-nav-item__text")).click();

        //Страница ввода логина
        driver.findElement(By.className("passp-form-field__input")).click();
        driver.findElement(By.name("login")).sendKeys("miffn1@yandex.ru");
        driver.findElement(By.cssSelector("div.passp-button:nth-child(12)")).click();

        //Страница ввода пароля
        driver.findElement(By.name("passwd")).sendKeys("webDriverIlichev19");
        driver.findElement(By.cssSelector(".passp-button")).click();

        //Проверка, что на главной странице кнопка "Войти в аккаунт" сменилась на "Мой профиль"
        String text = driver.findElement(By
                .cssSelector("span.header2-nav-item > span:nth-child(1) > span:nth-child(2)")).getText();
        Assert.assertTrue(text.equals("Мой профиль"));

    }

}
