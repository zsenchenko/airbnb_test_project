package tests.mobile;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("Android")
public class LoginTests extends TestBase {
    @Test
    @AllureId("11982")
    @DisplayName("Sign in with email")
    void logInByEmailAccount() {
        step("Open app", () -> {
            loginPage.openApp();
        });
        step("Press Continue with Email", () -> {
            loginPage.pressEmailLoginButton();
        });
        step("Login and password input", () -> {
            loginPage.enterLogin(config.userLogin());
            loginPage.enterPassword(config.userPassword());
        });
        step("Сhecking the login to the main page", () -> {
            explorePage.openExploreScreen();
        });
        step("Open profile", () -> {
            profilePage.openProfileScreen();
            profilePage.checkUserName("Petr");
        });
    }
}
