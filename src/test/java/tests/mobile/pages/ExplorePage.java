package tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ExplorePage {
    private final SelenideElement exploreScreen = $(AppiumBy.id("com.airbnb.android:id/2131427473"));
    private final SelenideElement exploreButton = $(AppiumBy.id("com.airbnb.android:id/2131431041"));
    private final SelenideElement searchBar = $(AppiumBy.id("com.airbnb.android:id/search_bar"));
    private final SelenideElement searchInput = $(AppiumBy.id("com.airbnb.android:id/search_input"));
    private final SelenideElement stays = $(AppiumBy.id("com.airbnb.android:id/2131431366"));
//    private final SelenideElement staysTwo = $(AppiumBy.xpath("//androidx.recyclerview.widget." +
//            "RecyclerView[@content-desc=\"Explore Airbnb\"]/android.widget.FrameLayout[2]"));
    private final SelenideElement heartButton = $(AppiumBy.id("com.airbnb.android:id/2131427872"));
    private final ElementsCollection searchScreen = $$(AppiumBy.className("android.widget.TextView"));
    private final ElementsCollection cardPlace = $$(AppiumBy.className("android.widget.ImageView"));

    public void openExploreScreen() {
        exploreScreen.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void checkExploreButton() {
        exploreButton.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void searchInput() {
        searchBar.click();
        searchInput.click();
    }

    public void selectLocation(String name) {
        searchScreen.findBy(Condition.text(name)).click();
        cardPlace.get(0).click();
    }

    public void staysLists() {
        stays.click();
        stays.click();
    }

    public void pressHeart() {
        heartButton.click();
    }
}
