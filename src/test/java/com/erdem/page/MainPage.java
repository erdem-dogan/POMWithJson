package com.erdem.page;

import com.erdem.base.BasePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainPage extends BasePage {
    public MainPage(RemoteWebDriver driver) {
        super(driver);
    }

    public MainPage justMain(){
        logger.info("Çağırıldı1.");
        return this;
    }
}
