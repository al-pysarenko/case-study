package com.finleap.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public SelenideElement loggedUserLabel = $("#greetings");
    public SelenideElement addUserBtn = $("#bAdd");
    public SelenideElement editUserBtn = $("#bEdit");
    public SelenideElement deleteUserBtn = $("#bDelete");
    public SelenideElement logoutBtn = $("header p.main-button");
    public ElementsCollection usersList = $$("#employee-list li");

    private CreateUserPage createUserPage = new CreateUserPage();
    private EditUserPage editUserPage = new EditUserPage();

    public MainPage addUser(String firstName, String lastName, String startDate, String email) {
        addUserBtn.click();
        createUserPage.addUser(firstName, lastName, startDate, email);
        return this;
    }

    public MainPage editUser(String firstName, String lastName, String startDate, String email) {
        editUserBtn.click();
        editUserPage.editUser(firstName, lastName, startDate, email);
        return this;
    }

    public MainPage deleteUser() {
        deleteUserBtn.click();
        Selenide.confirm();
        return this;
    }

    public LoginPage logout() {
        logoutBtn.click();
        return new LoginPage();
    }
}
