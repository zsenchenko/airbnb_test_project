package tests.mobile;

import com.codeborne.selenide.Configuration;
import config.mobile.AndroidEmulatorConfig;
import drivers.mobile.AndroidEmulatorMobileDriver;
import drivers.mobile.BrowserstackMobileDriver;
import drivers.mobile.RealDeviceMobileDriver;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.mobile.pages.ExplorePage;
import tests.mobile.pages.LoginPage;
import tests.mobile.pages.ProfilePage;
import tests.mobile.pages.WishListPage;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AllureAttachments.getSessionId;

public class TestBase {
    static AndroidEmulatorConfig config = ConfigFactory.create(AndroidEmulatorConfig.class, System.getProperties());

    static String deviceHost = System.getProperty("deviceHost", "browserStack");

    public LoginPage loginPage = new LoginPage();
    public ExplorePage explorePage = new ExplorePage();
    public ProfilePage profilePage = new ProfilePage();
    public WishListPage wishListPage = new WishListPage();

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
    }

    @BeforeEach
    public void beforeEach() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        AllureAttachments.screenshotAs("Screenshot");
        AllureAttachments.pageSource();
        closeWebDriver();
        if (Objects.equals(deviceHost, "browserStack")) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
