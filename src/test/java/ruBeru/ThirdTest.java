package ruBeru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

import org.testng.annotations.Test;


public class ThirdTest extends SupportSettings {

    @Test
    public void thirdTest() {

        //Открытие сайта
        open();

        driver.findElement(By.cssSelector("button._popup2-destructor")).click();
        WebElement hygiene = driver
                .findElement(By.cssSelector("a.n-navigation-vertical-category__link:nth-child(10) " +
                                            "> span:nth-child(1)"));
        Actions action = new Actions(driver);
        action.moveToElement(hygiene).build().perform();
        driver.findElement(By.xpath("//a[text() = 'Электрические зубные щетки']")).click();
        String count  = driver.findElement(By.className("_160zXyZIMr")).getText();
        System.out.println(count);
        driver.findElement(By.name("Цена от")).sendKeys("999");
        driver.findElement(By.name("Цена до")).sendKeys("1999");
        //driver.navigate().refresh();
        //List<WebElement> selected = driver.findElements(By.cssSelector("div.grid-snippet"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(By.className("_2w0qPDYwej"), 0));
        System.out.println(driver.findElement(By.className("_1PQIIOelRL")).getAttribute("textContent"));
        String[] foundResult = driver.findElement(By.className("_1PQIIOelRL"))
                .getAttribute("textContent").split(" ");
        System.out.println(foundResult[1]);
        List<WebElement> brushes = driver.findElements(By.className("_2w0qPDYwej"));
        brushes.get(brushes.size() - 3 ).click();
        //System.out.println(brushes.size());
//        System.out.println(selected.isEmpty());
//        Assert.assertFalse(selected.isEmpty());
    }

}
