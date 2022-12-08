package com.erdem.utility;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser {
    ChromeOptions chromeOptions;
    DesiredCapabilities capabilities;
    public ChromeOptions chromeOptions() {
        chromeOptions = new ChromeOptions();
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser", "chrome");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--lang=tr");
        System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver.exe");
        chromeOptions.merge(capabilities);
        return chromeOptions;
    }
}
