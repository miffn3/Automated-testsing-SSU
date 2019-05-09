package ruBeru;


import org.testng.annotations.Test;


public class SecondTest extends SupportSettings {

    @Test(dataProvider = "ChangeCity")
    public void secondTest(String cityName) {

        PageObjectMain pageObjectMain = new PageObjectMain(driver);
        PageObjectLogin pageObjectLogin = new PageObjectLogin(driver);
        PageObjectChangeCity pageObjectChangeCity = new PageObjectChangeCity(driver);
        PageObjectSettings pageObjectSettings = new PageObjectSettings(driver);

        //Смена города на "cityName"
        pageObjectMain.clickButtonChangeCity();
        pageObjectChangeCity.enterCity(cityName);
        pageObjectChangeCity.clickSuggestedCity();
        pageObjectChangeCity.clickEnterButtonCity();
        pageObjectMain.checkCity(cityName);

        //Авторизация
        pageObjectMain.clickButtonLogin();
        pageObjectLogin.enterLogin();
        pageObjectLogin.clickEnterButtonLogin();
        pageObjectLogin.enterPassword();
        pageObjectLogin.clickEnterButtonPassword();

        //Переходим в настройки и сравниваем город доставки
        pageObjectMain.clickButtonAccount();
        pageObjectMain.clickButtonSettings();
        pageObjectSettings.checkChangedCity();


        //Возвращение в исходное состояние
        //logout();
        }

}
