package com.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class SilenideTestWithLyambdaSteps extends BaseTest {

    private static final String REPOSITORY = "Dogmach/qa_guru_allure_lecture_1";

    @Test
    void lyambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу ", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Открываем репозиторйи ", () -> {
            $(By.linkText("Dogmach/qa_guru_allure_lecture_1")).click();
        });
        step("Переходим в там Issue ", () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issue с номером ", () -> {
            $(withText("Issue test for homework")).should(Condition.exist);
        });
    }
}
