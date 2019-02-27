package ruBeru;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SecondTest extends SupportSettings {

    //@Parameters({"city-name"})
    @Test
    public void secondTest() {

        //Открытие сайта
        open();

        //Смена города на "Хвалынск"
        driver.findElement(By.cssSelector(".region-form-opener > span:nth-child(1)")).click();
        driver.findElement(By.xpath("(//form[contains(@class,'region-select-form')]//input)[1]"))
                .sendKeys("Хвалынск", Keys.ENTER);
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div[1]/form/div/div/div[1]/div/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div[1]/form/div/button")).click();


//        driver.findElement(By
//                .xpath("/html/body/div[1]/div/div[1]/div[2]/noindex/div/div[1]/div/div/div[1]/span/span[2]")).click();
//        driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div[1]/form/div/div")).click();
//        driver.findElement(By.xpath("(//form[contains(@class, 'region-select-form')]//input)[1]"))
//                .sendKeys("Хвалынск", Keys.ENTER);
//        driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div[1]/form/div/div/div/div")).click();
//        driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div[1]/form/div/button")).click();


        //Авторизация
        //login();

        }

}
