package ruBeru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;


public class HighlighterClass {

    public void highlighterMethod(WebDriver driver, WebElement element) {
        new AShot().takeScreenshot(driver, element);
        new AShot()
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }
}
