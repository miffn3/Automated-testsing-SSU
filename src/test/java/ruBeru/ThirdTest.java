package ruBeru;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class ThirdTest extends SupportSettings {

    @Test
    public void thirdTest() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver);
        PageObjectToothbrushesSection pageObjectToothbrushesSection = new PageObjectToothbrushesSection(driver);
        PageObjectCart pageObjectCart = new PageObjectCart(driver);
        //Заходим в раздел электрических зубных щеток
        pageObjectMain.clickButtonCatalog();
        pageObjectMain.moveToSectionHygiene();
        pageObjectMain.clickSectionToothbrushes();
        //Вводим диапозон цен и добавляем щетку в корзину
        pageObjectToothbrushesSection.enterPriceMin();
        pageObjectToothbrushesSection.enterPriceMax();
        pageObjectToothbrushesSection.checkToothbrushCount();
        pageObjectToothbrushesSection.addToothbrush();
        pageObjectToothbrushesSection.clickButtonGoToCart();
        //Проверяем сумму необходимую для бесплатной доставки
        pageObjectCart.checkForFreeDelivery();
    }
}
