package tests.mobile;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("AndroidE2E")
public class E2ETest extends TestBase{
    @Disabled
    @Test
    @AllureId("11982")
    @DisplayName("Sign in with email")
    void logInByEmailAccount() {
        step("Open app", () -> {
            loginPage.openApp();
        });
        step("Press Continue with Email", () -> {
            loginPage.pressEmailLoginButton();
        });
        step("Login and password input", () -> {
            loginPage.enterLogin(config.userLogin());
            loginPage.enterPassword(config.userPassword());
        });
        step("Сhecking the login to the main page", () -> {
            explorePage.openExploreScreen();
        });
        step("Open profile", () -> {
            profilePage.openProfileScreen();
            profilePage.checkUserName("Petr");
        });
    }

    @Test
    @AllureId("11980")
    @DisplayName("Search and selection of location")
    void searchDestination() {
        step("Search page open check", () -> {
            explorePage.checkExploreButton();
        });
        step("Location search", () -> {
            explorePage.searchInput();
        });
        step("Location selection and open", () -> {
            explorePage.selectLocation("Maldives");
        });
    }

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
            wishListPage.favoritesList(2);
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
