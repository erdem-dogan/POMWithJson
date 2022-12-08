package com.erdem.base;

import com.erdem.model.SelectorInfo;
import com.erdem.page.MainPage;
import com.erdem.page.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends BaseTest {
    protected static int DEFAULT_DYNAMIC_WAIT_AMOUNT = 60;
    JavascriptExecutor executor = driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_DYNAMIC_WAIT_AMOUNT));

    public BasePage(WebDriver driver) {
        BaseTest.driver = (RemoteWebDriver) driver;
    }

    private boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void goToUrl(String url) {
        driver.get(url);
        logger.info(url + " adresine gidildi.");
    }

    public WebElement findElement(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        By infoParam = selectorInfo.getBy();
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(infoParam));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", webElement);
        return webElement;
    }

    public WebElement findElementWithoutWait(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        By infoParam = selectorInfo.getBy();
        WebElement webElement = driver.findElement(infoParam);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", webElement);
        return webElement;
    }

    public void javaScriptClick(String key){
        WebElement element = findElement(key);
        executor.executeScript("arguments[0].click();", element);
        logger.info(key + " elementine javascript ile tıklandı.");
    }

    public void click(String key){
        WebElement element = findElement(key);
        element.click();
        logger.info(key + " elementine tıklandı.");
    }

    public void sendKeys(String key, String text) {
        WebElement element = findElement(key);
        element.clear();
        element.sendKeys(text);
        logger.info(key + " elementine " + text + " yazısı yazıldı.");
    }

    public MainPage callMainPage(){
        return new MainPage(driver);
    }

    public ProductPage callProductPage() {
        return new ProductPage(driver);
    }
}
