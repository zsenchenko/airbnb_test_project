package tests.mobile.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WishListPage {
    private final SelenideElement wishlistButton = $(AppiumBy.id("com.airbnb.android:id/2131431055"));
    private final SelenideElement titleField = $(AppiumBy.id("com.airbnb.android:id/2131433219"));
    private final SelenideElement cardWishList = $(AppiumBy.id("com.airbnb.android:id/2131433215"));
    private final SelenideElement selectWishList = $(AppiumBy.id("com.airbnb.android:id/2131433211"));
    private final SelenideElement firstUncheckHeart = $(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Save to wishlist\"])[1]"));
    private final ElementsCollection favoritesList = $$(AppiumBy.xpath("//*[@resource-id='com.airbnb.android:id/2131428504']"));

    public void openWishListPage() {
        wishlistButton.shouldBe(visible, Duration.ofSeconds(10));
        wishlistButton.click();
    }

    public void wishList(String name) {
        titleField.shouldHave(text(name));
        cardWishList.click();
    }

    public void favoritesList(Integer number) {
        favoritesList.shouldHave(CollectionCondition.sizeGreaterThan(number));
    }

    public void uncheckHeart() {
        firstUncheckHeart.click();
    }

    public void selectWishList() {
        selectWishList.click();
    }
}
