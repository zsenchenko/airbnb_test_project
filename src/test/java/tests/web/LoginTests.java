package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("WEB")
public class LoginTests extends TestBase {

    @Test
    @DisplayName("Redirect of unauthorized user to login page")
    void redirectTest() {
        step("Check redirection", () -> {
            explorePage.addToFavorites();
            loginPage.openLoginPane();
        });
    }

    @Test
    @DisplayName("Authorization by e-mail")
    void loginTest() {
        step("Authorization", () -> {
            explorePage.openMenu();
            loginPage.doLogin(config.userLogin(), config.userPassword());
        });
        step("Check page content", () -> {

        });
    }
}