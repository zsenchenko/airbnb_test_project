package tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
//    private SelenideElement emailOption = $(".auth__subaction").$$(".auth__link").first();
// $(".input[name=email]");

    public SelenideElement
            mainMenuButton = $("[data-testid=cypress-headernav-profile]"),
            loginButton = $("[data-testid=cypress-headernav-login]"),
            authEmailButton = $("[data-testid=social-auth-button-email]"),
            emailField = $("[data-testid=email-login-email]"),
            passwordField = $("[data-testid=email-signup-password]"),

    heartButton = $(".bq05a0m"),
            loginPane = $("[data-testid=login-pane]");

    public void doLogin(String login, String password) {
        mainMenuButton.shouldBe(Condition.visible).click(); //visible убрать дома
        loginButton.shouldBe(Condition.visible).click();
        authEmailButton.shouldBe(Condition.visible).click();
        emailField.setValue(login).pressEnter();
        passwordField.setValue(password).pressEnter();
    }

    public void addToFavorites() {
        heartButton.click();
        loginPane.shouldBe(Condition.visible);
    }
}
