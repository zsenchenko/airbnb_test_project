package tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.model.WishListData;
import tests.api.model.get.DataTest;
import tests.api.model.post.AddToWishListRequest;
import tests.api.model.post.WishListedListing;
import tests.api.specs.Specs;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.api.specs.Specs.requestGet;
import static tests.api.specs.Specs.requestPost;

@Tag("API")
public class ApiTests extends TestBase {
    public String id;

    @Test
    @DisplayName("Сheck for a specific wishlist")
    void checkWishList() {
        DataTest data = given()
                .spec(requestGet)
                .when()
                .get("/api/v3/WishlistIndexPageQuery")
                .then()
                .spec(Specs.response)
                .extract().as(DataTest.class);
        assertEquals("Maldives", data.
                getPresentation().
                getWishlistIndexPage().
                getWishLists().
                getL().
                get(0).
                getName());
    }

    @Test
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
        assertEquals("21375511", data.
                getListing().
                getWishListedO().
                getId());
    }

    @Test
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
    @DisplayName("Create a new wishlist")
    void createWishList() {
        String body = "{ \"name\":\"Norway\" }";

        id = given()
                .spec(requestPost)
                .body(body)
                .when()
                .post("/api/v2/wishlists")
                .then()
                .log().status()
                .spec(Specs.response).extract().as(WishListData.class).
                getWishlist().
                getId();
    }

    @Test
    @DisplayName("Delete a new wishlist")
    void deleteWishList() {
        given()
                .spec(requestPost)
                .when()
                .delete("/api/v2/wishlists/" + id)
                .then()
                .log().status()
                .spec(Specs.response);
    }
}
