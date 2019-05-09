package ruBeru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectCart {

    private WebDriver driver;
    private WebElement deliveryWindow;
    private WebElement priceToFreeDelivery;
    private WebElement priceOfTheToothbrush;
    private WebElement addButton;

    public PageObjectCart(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Add more toothbrushes for free delivery")
    public void checkForFreeDelivery() {
        deliveryWindow = driver.findElement(By.cssSelector("._3yDgi6ylNe>span"));
        if (!deliveryWindow.getAttribute("textContent")
                .equals("Поздравляем! Вы получили бесплатную доставку на ваш заказ")) {
            priceToFreeDelivery = driver.findElement(By.cssSelector(".voCFmXKfcL"));
            priceOfTheToothbrush = driver.findElement(By.cssSelector("._1JLs4_hnVR > span:nth-child(1)"));
            int priceValueDelivery = Integer.valueOf(
                    priceToFreeDelivery.getText().replaceAll("\\D+", ""));
            int priceValueToothBrush = Integer.valueOf(
                    priceOfTheToothbrush.getText().replaceAll("\\D+", ""));
            int count = priceValueDelivery / priceValueToothBrush;
            addButton = driver.findElement(By.xpath("//span[contains(text(), '+')]"));
            for (int i = 0; i <= count; i++) {
                addButton.click();
            }
        }
    }
}
