package ruBeru;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;
import ru.yandex.qatools.ashot.cropper.indent.BlurFilter;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class HighlighterClass {

    public void highlighterMethod(WebDriver driver, WebElement element) {
        AShot scr = new AShot();
        scr.imageCropper(new IndentCropper().addIndentFilter(new BlurFilter()))
                .takeScreenshot(driver, element);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
        String name = "/Users/ilyichev/IdeaProjects/webdrivertngs/src/test/screenshots/" + dateFormat.format(date) + ".png";
        try {
            Screenshot sc = new AShot().imageCropper(new IndentCropper(2560).addIndentFilter(new BlurFilter()))
                    .takeScreenshot(driver, element);
            BufferedImage bf = sc.getImage();
            ImageIO.write(bf, "PNG", new File(name));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
