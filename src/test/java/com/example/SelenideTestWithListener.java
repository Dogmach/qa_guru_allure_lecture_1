package com.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelenideTestWithListener extends BaseTest {


    @Test
    void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").setValue("Dogmach").pressEnter();
        String currentUrl = getWebDriver().getCurrentUrl();
        assertTrue(currentUrl.equals("https://github.com/search?q=Dogmach&type="));

        $(".col-12.col-md-3.float-left.px-md-2").$(byText("Users")).click();
        $(".d-flex.hx_hit-user.px-0.Box-row").$(byText("Dogmach")).click();
        currentUrl = getWebDriver().getCurrentUrl();
        assertTrue(currentUrl.equals("https://github.com/Dogmach"));

        $("[data-tab-item=repositories]").click();
        $("#your-repos-filter").setValue("qa_guru_allure_lecture_1").pressEnter();
        $("[data-filterable-for=your-repos-filter]").$(byText("qa_guru_allure_lecture_1")).click();
        currentUrl = getWebDriver().getCurrentUrl();
        assertTrue(currentUrl.equals("https://github.com/Dogmach/qa_guru_allure_lecture_1"));


        $(By.partialLinkText("Issues")).click();
        $(withText("Issue test for homework")).should(Condition.exist);

    }
}
