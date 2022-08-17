package tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {
    private final SelenideElement profileButton = $(AppiumBy.id("com.airbnb.android:id/2131431035"));
    private final ElementsCollection profileScreen = $$(AppiumBy.className("android.widget.TextView"));

    public void openProfileScreen() {
        profileButton.click();
    }

    public void checkUserName(String name) {
        profileScreen.find(Condition.text(name))
                .shouldBe(Condition.visible);
    }
}
