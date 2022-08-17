package tests.mobile;

import com.codeborne.selenide.Configuration;
import config.mobile.AndroidEmulatorConfig;
import drivers.AndroidEmulatorMobileDriver;
import drivers.BrowserstackMobileDriver;
import drivers.RealDeviceMobileDriver;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.mobile.pages.ExplorePage;
import tests.mobile.pages.LoginPage;
import tests.mobile.pages.ProfilePage;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AllureAttachments.sessionId;

public class TestBase {
    static AndroidEmulatorConfig config = ConfigFactory.create(AndroidEmulatorConfig.class, System.getProperties());

    static String deviceHost = System.getProperty("deviceHost", "emulator");
    public LoginPage loginPage = new LoginPage();
    public ExplorePage explorePage = new ExplorePage();
    public ProfilePage profilePage = new ProfilePage();

    @BeforeAll
    public static void setup() {
        if (Objects.equals(deviceHost, "emulator")) {
            Configuration.browser = AndroidEmulatorMobileDriver.class.getName();
        } else if (Objects.equals(deviceHost, "browserStack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else if (Objects.equals(deviceHost, "local")) {
            Configuration.browser = RealDeviceMobileDriver.class.getName();
        } else {
            throw new RuntimeException("Incorrect stand name");
        }

        Configuration.browserSize = null;
        addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void beforeEach() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();

        AllureAttachments.screenshotAs("Screenshot");
        AllureAttachments.pageSource();
        closeWebDriver();
        if (Objects.equals(deviceHost, "browserStack")) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
