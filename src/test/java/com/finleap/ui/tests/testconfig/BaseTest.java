package com.finleap.ui.tests.testconfig;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static final String USERNAME = "Luke";
    protected static final String PASSWORD = "Skywalker";

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://cafetownsend-angular-rails.herokuapp.com";
        Configuration.timeout = 10000;
    }
}
