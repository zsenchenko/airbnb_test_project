package tests;

import com.codeborne.selenide.Configuration;
import drivers.AndroidEmulatorMobileDriver;
import drivers.BrowserstackMobileDriver;
import drivers.RealDeviceMobileDriver;
import helpers.AllureAttachments;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static helpers.AllureAttachments.sessionId;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import java.util.Objects;

public class TestBase {

    static String deviceHost = System.getProperty("deviceHost", "local");

    @BeforeAll
    public static void setup() {
        if (Objects.equals(deviceHost, "browserStack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else if (Objects.equals(deviceHost, "emulator")) {
            Configuration.browser = AndroidEmulatorMobileDriver.class.getName();
        } else {
            Configuration.browser = RealDeviceMobileDriver.class.getName();
        }

        Configuration.browserSize = null;
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();

        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();

        closeWebDriver();
        if (Objects.equals(deviceHost, "browserStack")) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}


