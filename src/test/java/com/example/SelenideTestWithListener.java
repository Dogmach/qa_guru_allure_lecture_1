package com.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTestWithListener {

    @AfterEach
    void afterEach(){
        closeWebDriver();
    }

    @Test
    void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Dogmach/qa_guru_allure_lecture_1");
        $(".header-search-input").submit();

        $(By.linkText("Dogmach/qa_guru_allure_lecture_1")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("Issue test for homework")).should(Condition.exist);

    }
}
