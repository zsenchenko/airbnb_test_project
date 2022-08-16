package tests.mobile;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class LoginTests extends TestBase{
    @Test
    @DisplayName("User authorization with email and password")
    void logInTest() {

        $(AppiumBy.id("com.airbnb.android:id/2131428930")).shouldBe(visible, Duration.ofSeconds(10));
        step("LogIn", () -> {
            $(AppiumBy.id("com.airbnb.android:id/2131428930")).click();
            $(AppiumBy.id("com.airbnb.android:id/2131428917")).sendKeys("romanovpetr21@yandex.ru");
            $(AppiumBy.id("com.airbnb.android:id/2131429481")).click();
            $(AppiumBy.id("com.airbnb.android:id/2131428917")).sendKeys("Bz8UkgK@X");
            $(AppiumBy.id("com.airbnb.android:id/2131429481")).click();
            $(AppiumBy.id("com.airbnb.android:id/2131427473")).shouldBe(visible, Duration.ofSeconds(10));
        });
        step("Open profile", () -> {
            $(AppiumBy.id("com.airbnb.android:id/2131431035")).click();
            $$(AppiumBy.className("android.widget.TextView"))
                    .find(Condition.text("Petr"))
                    .shouldBe(Condition.visible);
        });
    }
}
