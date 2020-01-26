package com.finleap.ui.tests;

import com.finleap.ui.pages.LoginPage;
import com.finleap.ui.pages.MainPage;
import com.finleap.ui.tests.testconfig.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class UserActionsTest extends BaseTest {

    MainPage mainPage = new MainPage();

    private String lastName;

    @BeforeEach
    public void init() {
        LoginPage.open()
                .loginUser(USERNAME, PASSWORD);

        lastName = randomAlphabetic(6);
    }

    @Test
    void testCanCreateUser() {
        mainPage.addUser("User", lastName, "2020-03-01", lastName + "@mail.com")
                .usersList.findBy(exactText("User " + lastName))
                .shouldBe(visible);
    }

    @Test
    void testCanEditUser() {
        String newLastName = randomAlphabetic(6);

        mainPage.addUser("User", lastName, "2020-03-01", lastName + "@mail.com")
                .usersList.findBy(exactText("User " + lastName))
                .click();

        mainPage.editUser("User", newLastName, "2020-03-01", newLastName + "@mail.com")
                .usersList.findBy(exactText("User " + newLastName))
                .shouldBe(visible);
    }

    @Test
    void testCanDeleteUser() {
        mainPage.addUser("User", lastName, "2020-03-01", lastName + "@mail.com")
                .usersList.findBy(exactText("User " + lastName))
                .click();

        mainPage.deleteUser()
                .usersList.findBy(exactText("User " + lastName))
                .shouldNot(exist);
    }

    @Test
    void testCanLogout() {
        mainPage.logout()
                .loginBtn
                .shouldBe(visible);
    }
}
