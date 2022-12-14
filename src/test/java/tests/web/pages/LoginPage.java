package tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement
            loginButton = $("[data-testid=cypress-headernav-login]"),
            authEmailButton = $("[data-testid=social-auth-button-email]"),
            emailField = $("[data-testid=email-login-email]"),
            passwordField = $("._11hx67x"),
            loginPane = $("[data-testid=login-pane]");

    public void doLogin(String login) {
        loginButton.click();
        authEmailButton.click();
        emailField.setValue(login).pressEnter();
    }

    public void doPassword(String password) {
        passwordField.click();
        passwordField.setValue(password).pressEnter();
    }

    public void openLoginPane() {
        loginPane.shouldBe(Condition.visible);
    }
}
