package com.erdem.utility;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class Browser {
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;
    SafariOptions safariOptions;
    DesiredCapabilities capabilities;

    public String browserName = "chrome";
    public String platformName = "windows";


    public ChromeOptions chromeOptions() {
        chromeOptions = new ChromeOptions();
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser", "chrome");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--lang=tr");
        if ("windows".equalsIgnoreCase(platformName)){
            System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver.exe");
        } else if ("mac".equalsIgnoreCase(platformName)) {
            System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver");
        }
        chromeOptions.merge(capabilities);
        return chromeOptions;
    }

    public EdgeOptions edgeOptions() {
        edgeOptions = new EdgeOptions();
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser", "edge");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--lang=tr");
        System.setProperty("webdriver.chrome.driver", "web_driver/msedgedriver.exe");
        edgeOptions.merge(capabilities);
        return edgeOptions;
    }

    public SafariOptions safariOptions() {
        safariOptions = new SafariOptions();
        return safariOptions;
    }
}
