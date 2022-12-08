package com.erdem.test;

import com.erdem.base.BaseTest;
import com.erdem.page.LoginPage;
import org.junit.Before;
import org.junit.Test;

public class Tests extends BaseTest {
    LoginPage loginPage;

    @Before
    public void before(){
        loginPage = new LoginPage(getDriver());
    }

    @Test
    public void test() throws InterruptedException {
        loginPage.login().callMainPage().justMain().callProductPage().justProduct();
    }
}
