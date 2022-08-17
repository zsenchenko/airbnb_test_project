package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement emailLoginButton = $(AppiumBy.id("com.airbnb.android:id/2131428930"));
    private final SelenideElement emailAndPasswordButton = $(AppiumBy.id("com.airbnb.android:id/2131428917"));
    private final SelenideElement continueButton = $(AppiumBy.id("com.airbnb.android:id/2131429481"));

    public void openApp() {
        emailLoginButton.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void pressEmailLoginButton() {
        emailLoginButton.click();
    }

    public void enterLogin(String email) {
        emailAndPasswordButton.sendKeys(email);
        continueButton.click();
    }

    public void enterPassword(String password) {
        emailAndPasswordButton.sendKeys(password);
        continueButton.click();
    }
}
