package tests.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.CustomApiListener;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeAll
    static void setup() {
        RestAssured.filters(CustomApiListener.withCustomTemplates());
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}



