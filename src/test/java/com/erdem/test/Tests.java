package com.erdem.test;

import com.erdem.base.BaseTest;
import com.erdem.page.LoginPage;
import org.junit.jupiter.api.Test;

public class Tests extends BaseTest {
    LoginPage loginPage;

    @Test
    public void test() throws InterruptedException {
        loginPage = new LoginPage(getDriver());
        loginPage.login().callMainPage().justMain().callProductPage().justProduct();
    }
}
