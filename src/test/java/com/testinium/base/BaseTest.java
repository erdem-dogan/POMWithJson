package com.testinium.base;

import com.testinium.selector.Selector;
import com.testinium.selector.SelectorFactory;
import com.testinium.selector.WebSelector;
import com.testinium.test.Tests;
import com.testinium.utility.Browser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static RemoteWebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(Tests.class);

    protected static Selector selector;
    Browser browser = new Browser();

    @Before
    public void setUp(){
        logger.info("Test ayağa kalkıyor.");
        driver = new ChromeDriver(browser.chromeOptions());
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        selector = SelectorFactory.createElementHelper();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public static RemoteWebDriver getDriver() {
        return driver;
    }
}
