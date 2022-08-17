package tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

//@Tag("Android")
public class WishListTests extends TestBase {
    @Test
    @DisplayName("Add a space to wishlist")
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
    }

    @Test
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
    @DisplayName("Remove space from the wishlist")
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
