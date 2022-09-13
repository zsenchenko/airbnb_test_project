package tests.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.web.WebConfig;
import drivers.web.BrowserWebDriver;
import helpers.AllureAttachments;

import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.web.pages.ExplorePage;
import tests.web.pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static helpers.AllureAttachments.getSessionId;

public class TestBase {
    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
    static String webHost = System.getProperty("webHost", "local");

    public LoginPage loginPage = new LoginPage();
    public ExplorePage explorePage = new ExplorePage();

    @BeforeAll
    static void setUp() {
        BrowserWebDriver.configure();
    }

    @BeforeEach
    public void beforeEach() {
        open(config.baseURL());
    }
    public void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();
        AllureAttachments.screenshotAs("Screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        if (webHost.equals("remote")) {
            AllureAttachments.videoSelenoid(sessionId);
        }
        closeWebDriver();
    }

}
