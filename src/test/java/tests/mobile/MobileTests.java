package tests.mobile;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class MobileTests extends TestBase {

    @Disabled
    @Test
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

    @Disabled
    @Test
    void searchTest() {
        $(AppiumBy.id("com.airbnb.android:id/2131431041")).shouldBe(visible, Duration.ofSeconds(5));
        //  $(AppiumBy.id("com.airbnb.android:id/2131431041")).click();
        $(AppiumBy.id("com.airbnb.android:id/search_bar")).click();
        $(AppiumBy.id("com.airbnb.android:id/search_input")).click();
        $$(AppiumBy.className("android.widget.TextView"))
                .findBy(Condition.text("Maldives · Stays"))
                .click();
        $$(AppiumBy.className("android.widget.ImageView")).get(0)
                .click();

        $(AppiumBy.id("com.airbnb.android:id/2131431366")).click();
        $(AppiumBy.id("com.airbnb.android:id/2131427872")).click();
        $(AppiumBy.id("com.airbnb.android:id/2131433211")).click();
    }

    @Disabled
    @Test
    void addedWishlistTest() {
        $(AppiumBy.id("com.airbnb.android:id/2131431055")).shouldBe(visible, Duration.ofSeconds(7));
        $(AppiumBy.id("com.airbnb.android:id/2131431055")).click(); //com.airbnb.android:id/2131431055
        $(AppiumBy.id("com.airbnb.android:id/2131433219")).shouldHave(text("Мальдивы"));
        $(AppiumBy.id("com.airbnb.android:id/2131433215")).click();
        $$(AppiumBy.xpath("//*[@resource-id='com.airbnb.android:id/2131428504']"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(3));
    }

    @Test
    void deletedWishlistTest() {
        $(AppiumBy.id("com.airbnb.android:id/2131431055")).shouldBe(visible, Duration.ofSeconds(7));
        $(AppiumBy.id("com.airbnb.android:id/2131431055")).click();
        $(AppiumBy.id("com.airbnb.android:id/2131433219")).shouldHave(text("Мальдивы"));
        $(AppiumBy.id("com.airbnb.android:id/2131433215")).click();
        $(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Save to wishlist\"])[1]"))
                .click();
        $$(AppiumBy.xpath("//*[@resource-id='com.airbnb.android:id/2131428504']"))
                .shouldHave(CollectionCondition.sizeGreaterThan(2));
    }
}


