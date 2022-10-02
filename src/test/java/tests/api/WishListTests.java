package tests.api;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.model.get.WishListDataGet;
import tests.api.model.post.WishListDataPost;
import tests.api.model.post.WishListedListing;
import tests.api.model.post.requests.AddToWishListRequest;
import tests.api.model.post.requests.CreateWishListRequest;
import tests.api.specs.Specs;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.api.specs.Specs.requestGet;
import static tests.api.specs.Specs.requestPost;

@Tag("API")
public class WishListTests extends TestBase {

    @Test
    @AllureId("12226")
    @DisplayName("Сheck for a specific wishlist")
    void checkWishList() {
        WishListDataGet data = given()
                .spec(requestGet)
                .when()
                .get("/api/v3/WishlistIndexPageQuery")
                .then()
                .spec(Specs.response)
                .extract().as(WishListDataGet.class);
        assertEquals("Maldives", data
                .getPresentation()
                .getWishlistIndexPage()
                .getWishLists()
                .getWishlist()
                .get(0)
                .getName());
    }

    @Test
    @AllureId("12227")
    @DisplayName("Add favorites to the wishlist")
    void addToWishList() {
        AddToWishListRequest body = new AddToWishListRequest();
        body.setWishlistId("1144175595");
        body.setListingId("21375511");
        body.setEntityType("collection_hosting");
        body.setFormat("default");

        WishListedListing data = given()
                .spec(requestPost)
                .body(body)
                .when()
                .post("/api/v2/wishlisted_listings")
                .then()
                .spec(Specs.response)
                .extract().as(WishListedListing.class);
        assertEquals("21375511", data
                .getListing()
                .getListingId()
                .getId());
    }

    @Test
    @AllureId("12228")
    @DisplayName("Delete favorites from the wishlist")
    void deleteFromWishList() {
        given()
                .spec(requestPost)
                .when()
                .delete("/api/v2/wishlisted_listings/1144175595/21375511")
                .then()
                .log().status()
                .spec(Specs.response);
    }

    @Test
    @AllureId("12229")
    @DisplayName("Create and delete the wishlist")
    void createWishList() {
        CreateWishListRequest body = new CreateWishListRequest();
        body.setName("Norway");

        wishlistId = given()
                .spec(requestPost)
                .body(body)
                .when()
                .post("/api/v2/wishlists")
                .then()
                .log().status()
                .spec(Specs.response)
                .extract().as(WishListDataPost.class)
                .getWishlist()
                .getId();

        deleteWishList.deleteWishList();
    }
}
