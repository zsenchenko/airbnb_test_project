package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement emailOption = $(".auth__subaction").$$(".auth__link").first();
    private final SelenideElement emailField = $(".input[name=email]");
    private final SelenideElement passwordField = $(".input[name=password]");
}
