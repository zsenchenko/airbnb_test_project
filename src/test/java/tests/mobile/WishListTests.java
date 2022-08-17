package tests.mobile;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

//@Tag("Android")
public class WishListTests {
    @Test
    @DisplayName("Add a space to wishlist")
    void addToWishList() {
        step("Select and view a place", () -> {

        });
        step("Сlick on the heart", () -> {

        });
    }

    @Test
    @DisplayName("Check that the wishlist is not empty")
    void checkWishlist() {
        $(AppiumBy.id("com.airbnb.android:id/2131431055")).shouldBe(visible, Duration.ofSeconds(7));
        $(AppiumBy.id("com.airbnb.android:id/2131431055")).click(); //com.airbnb.android:id/2131431055
        $(AppiumBy.id("com.airbnb.android:id/2131433219")).shouldHave(text("Мальдивы"));
        $(AppiumBy.id("com.airbnb.android:id/2131433215")).click();
        $$(AppiumBy.xpath("//*[@resource-id='com.airbnb.android:id/2131428504']"))
                .shouldHave(CollectionCondition.sizeGreaterThan(3));
    }

    @Test
    @DisplayName("Remove space from the wishlist")
    void deleteFromWishlist() {
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
