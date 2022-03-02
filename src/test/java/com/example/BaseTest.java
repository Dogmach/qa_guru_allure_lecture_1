package com.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeEach
    void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
