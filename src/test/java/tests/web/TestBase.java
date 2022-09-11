package tests.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.web.BrowserWebDriver;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUp() {
        BrowserWebDriver.configure();
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        AllureAttachments.screenshotAs("Screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
//        if (useRemote.equals("remote")) {
//            AllureAttachments.addVideo();
//        }
        closeWebDriver();
    }
}
