package tests.web;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("WEB")
public class LoginTests extends TestBase {

    @Test
    @AllureId("12216")
    @DisplayName("Redirect of unauthorized user to login page")
    void redirectTest() {
        step("Click on the heart", () -> {
            explorePage.addToFavorites();
        });
        step("Check redirection", () -> {
            loginPage.openLoginPane();
        });
    }

    @Test
    @AllureId("12218")
    @DisplayName("Authorization by e-mail")
    void loginTest() {
        step("Authorization", () -> {
            explorePage.openMenu();
            loginPage.doLogin(config.userLogin());
            loginPage.doPassword(config.userPassword());
        });
        step("Check authorization", () -> {
            explorePage
                    .openMenu()
                    .checkAccount();
        });
    }
}
