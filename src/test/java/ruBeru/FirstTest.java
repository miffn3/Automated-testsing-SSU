package ruBeru;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTest extends SupportSettings {

    @Test
    public void firstTest() {

        //Открытие сайта
        open();

        //Авторизация на сайте
        login();

        //Проверка, что на главной странице кнопка "Войти в аккаунт" сменилась на "Мой профиль"
        String text = driver.findElement(By.className("header2-nav__user")).getText();
        Assert.assertTrue(text.equals("Мой профиль"));

        //Возрат в исходное состояние
        logout();

    }

}
