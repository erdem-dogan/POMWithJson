package com.testinium.page;

import com.testinium.base.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login() throws InterruptedException {
        goToUrl("https://www.amazon.com.tr/");
        Thread.sleep(3000);
        click("navLogo");
        return this;
    }
}
