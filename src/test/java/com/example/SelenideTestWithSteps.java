package com.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTestWithSteps extends BaseTest {

    public final static String REPORSITORY = "Dogmach/qa_guru_allure_lecture_1";
    public final static String ISSUE_VALUE = "Issue test for homework";

    @Step("Открываем главную страницу ")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo} ")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Открываем репозиторий {repo}")
    public void openRepository(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Переходим в таб Issue")
    public void openOpenIssueTab() {
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Проверяем что существует Issue")
    public void openSeeIssue(String value) {
        $(withText(value)).should(Condition.exist);
    }

    @Test
    public void testAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        SelenideTestWithSteps selenideTestWithSteps = new SelenideTestWithSteps();

        selenideTestWithSteps.openMainPage();
        selenideTestWithSteps.searchForRepository(REPORSITORY);
        selenideTestWithSteps.openRepository(REPORSITORY);
        selenideTestWithSteps.openOpenIssueTab();
        selenideTestWithSteps.openSeeIssue(ISSUE_VALUE);

    }

}