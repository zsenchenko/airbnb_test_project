package tests.mobile;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("Android")
public class WishListTests extends TestBase {
    @Test
    @AllureId("11979")
    @DisplayName("Add a place to wishlist")
    void addToWishList() {
        step("Open search page", () -> {
            explorePage.checkExploreButton();
        });
        step("Select and open the first place", () -> {
            explorePage.staysLists();
        });
        step("Сlick on the heart", () -> {
            explorePage.pressHeart();
        });
        step("Select a wishlist to add", () -> {
            wishListPage.selectWishList();
        });
    }

    @Test
    @AllureId("11978")
    @DisplayName("Check that the wishlist is not empty")
    void checkWishlist() {
        step("Open wishlists page", () -> {
            wishListPage.openWishListPage();
        });
        step("Find a specific wishlist", () -> {
            wishListPage.wishList("Maldives");
        });
        step("Сhecking for favorites in it", () -> {
            wishListPage.favoritesList(3);
        });
    }

    @Test
    @AllureId("11981")
    @DisplayName("Remove place from the wishlist")
    void deleteFromWishlist() {
        step("Open wishlists page", () -> {
            wishListPage.openWishListPage();
        });
        step("Find a specific wishlist", () -> {
            wishListPage.wishList("Maldives");
        });
        step("Delete the first in the favorites list", () -> {
            wishListPage.uncheckHeart();
        });
        step("Сhecking that favorite has been deleted", () -> {
            wishListPage.favoritesList(2);
        });
    }
}
