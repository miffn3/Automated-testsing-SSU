package ruBeru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectLogin {

    private WebDriver driver;
    private WebElement fieldLogin;
    private WebElement fieldPassword;
    private WebElement enterButtonLogin;
    private WebElement enterButtonPassword;

    public PageObjectLogin(WebDriver webDriver) {
        this.driver = webDriver;
    }

    @Step("Enter login")
    public void enterLogin() {
        fieldLogin = driver.findElement(By.name(""));
        fieldLogin.sendKeys("");
    }

    @Step("Click enter login button")
    public void clickEnterButtonLogin() {
        enterButtonLogin = driver.findElement(By.cssSelector("div.passp-button:nth-child(12)"));
        enterButtonLogin.click();
    }

    @Step("Enter password")
    public void enterPassword() {
        fieldPassword = driver.findElement(By.name("passwd"));
        fieldPassword.sendKeys("webDriverIlichev19");
    }

    @Step("Click enter password button")
    public void clickEnterButtonPassword() {
        enterButtonPassword = driver.findElement(By.className("passp-sign-in-button"));
        enterButtonPassword.click();
    }
}

