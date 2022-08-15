package tests;

import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import config.Project;
import config.demowebshop.App;
import helpers.AllureAttachments;
import helpers.DriverSettings;
import helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
public class TestBase {

@ExtendWith({AllureJunit5.class})
public class TestBase {
    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
        RestAssured.baseURI = App.config.baseURI();
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}

}
