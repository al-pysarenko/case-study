package com.finleap.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement userNameInput = $("#login-form label:nth-of-type(1) input");
    private SelenideElement passwordInput = $("#login-form label:nth-of-type(2) input");
    public SelenideElement loginBtn = $("#login-form button");
    public SelenideElement invalidCredentialsMsg = $("p.error-message");

    public static LoginPage open() {
        return Selenide.open("/login", LoginPage.class);
    }

    public MainPage loginUser(String username, String password) {
        userNameInput.setValue(username);
        passwordInput.setValue(password);
        loginBtn.click();
        return new MainPage();
    }
}
