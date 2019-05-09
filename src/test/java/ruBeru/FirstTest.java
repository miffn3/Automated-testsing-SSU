package ruBeru;

import org.testng.annotations.*;

@Listeners({TestListener.class})
public class FirstTest extends SupportSettings {

    @Test
    public void firstTest() {

        PageObjectMain pageObjectMain = new PageObjectMain(driver);
        PageObjectLogin pageObjectLogin = new PageObjectLogin(driver);

        //Авторизация
        pageObjectMain.clickButtonLogin();
        pageObjectLogin.enterLogin();
        pageObjectLogin.clickEnterButtonLogin();
        pageObjectLogin.enterPassword();
        pageObjectLogin.clickEnterButtonPassword();

        //Проверка, что кнопка сменилась на "Мой профиль"
        pageObjectMain.checkText();

    }

}
