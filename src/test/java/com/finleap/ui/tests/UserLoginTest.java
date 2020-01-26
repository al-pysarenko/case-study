package com.finleap.ui.tests;

import com.finleap.ui.pages.LoginPage;
import com.finleap.ui.tests.testconfig.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;

public class UserLoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    void testCanLoginAsAdmin() {
        LoginPage.open()
                .loginUser(USERNAME, PASSWORD)
                .loggedUserLabel
                .shouldHave(exactText("Hello " + USERNAME));
    }

    @Test
    void testCanNotLoginWithInvalidCredentials() {
        String userName = "Baby";

        LoginPage.open()
                .loginUser(userName, "Yoda");

        loginPage.invalidCredentialsMsg
                .shouldHave(exactText("Invalid username or password!"));
    }
}
