package com.erdem.base;

import com.erdem.selector.Selector;
import com.erdem.selector.SelectorFactory;
import com.erdem.test.Tests;
import com.erdem.utility.Browser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BaseTest {
    protected static RemoteWebDriver driver;
    protected static Logger logger = LoggerFactory.getLogger(Tests.class);

    protected static Selector selector;
    static Browser browser = new Browser();

    @BeforeAll
    public static void setUp() {
        logger.info("********************TEST BAŞLIYOR********************");
        if ("chrome".equalsIgnoreCase(browser.browserName)) {
            driver = new ChromeDriver(browser.chromeOptions());
        } else if ("edge".equalsIgnoreCase(browser.browserName)) {
            driver = new EdgeDriver(browser.edgeOptions());
        } else if ("safari".equalsIgnoreCase(browser.browserName)) {
            driver = new SafariDriver(browser.safariOptions());
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        selector = SelectorFactory.createElementHelper();
    }

    @AfterAll
    public static void tearDown() {
        logger.info("********************TEST SONLANDI********************");
        driver.quit();
    }

    public static RemoteWebDriver getDriver() {
        return driver;
    }
}
