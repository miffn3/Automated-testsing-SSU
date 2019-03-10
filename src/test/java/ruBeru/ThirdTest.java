package ruBeru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ThirdTest extends SupportSettings {

    @Test
    public void thirdTest() {

        //Открытие сайта
        open();

        driver.findElement(By.cssSelector("button._popup2-destructor")).click();
        WebElement hygiene = driver.findElement(By.cssSelector("a.n-navigation-vertical-category__link:nth-child(10) " +
                                            "> span:nth-child(1)"));
        Actions action = new Actions(driver);
        action.moveToElement(hygiene).build().perform();
        driver.findElement(By.xpath("//a[text() = 'Электрические зубные щетки']")).click();
        driver.findElement(By.name("Цена от")).sendKeys("9999");
        driver.findElement(By.name("Цена до")).sendKeys("1999");
        Assert.assertTrue(driver.findElements(
                By.xpath("//div[contains(@class, ’serp-empty island’)]")).size() > 0);
    }

}
