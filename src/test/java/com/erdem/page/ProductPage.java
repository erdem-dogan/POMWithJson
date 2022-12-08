package com.erdem.page;

import com.erdem.base.BasePage;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage justProduct() {
        logger.info("Çağırıldı2.");
        return this;
    }
}
