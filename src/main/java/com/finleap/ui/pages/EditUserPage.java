package com.finleap.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EditUserPage {

    public SelenideElement firstNameInput = $("form label:nth-of-type(1) input");
    public SelenideElement lastNameInput = $("form label:nth-of-type(2) input");
    public SelenideElement startDateInput = $("form label:nth-of-type(3) input");
    public SelenideElement emailInput = $("form label:nth-of-type(4) input");
    public SelenideElement editUserBtn = $(".formFooter button:nth-of-type(1)");

    public void editUser(String firstName, String lastName, String startDate, String email) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        startDateInput.setValue(startDate);
        emailInput.setValue(email);
        editUserBtn.click();
    }
}
