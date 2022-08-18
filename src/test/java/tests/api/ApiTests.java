package tests.api;

import tests.api.specs.Specs;
import tests.api.model.get.DataTest;
import tests.api.model.post.WishListedListing;
import org.junit.jupiter.api.Test;

import static tests.api.specs.Specs.requestGet;
import static tests.api.specs.Specs.requestPost;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTests extends TestBase{

    String extensions = "%7B%22persistedQuery%22%3A%7B%22version%22%3A1%2C%22sha256Hash%22%3A%221efb9703aaab3d1721b5e92a8119118753956223dab146c853ea4a50bf022e33%22%7D%7D";
    String key = "d306zoyjsyarp7ifhu67rjxn52tv0t20";


    @Test
    void getWishList() {
        DataTest data = given()
                .log().all()
                .spec(requestGet)
                .urlEncodingEnabled(false)
                .queryParam("extensions", extensions)
                .when()
                .get("/api/v3/WishlistIndexPageQuery")
                .then()
                .log().status()
                .log().all()
                .log().body()
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
    void addWishList() {

        String body = "{ \"wishlist_id\" :\"1144175595\", " +
                "\"listing_id\": \"21375511\"," +
                "\"entity_type\":\"collection_hosting\"," +
                "\"_format\":\"default\" }";

        WishListedListing data =  given()
                .spec(requestPost)
                .urlEncodingEnabled(false)
                .queryParam("key", key)
                .body(body)
                .when()
                .post("/api/v2/wishlisted_listings")
                .then()
                .log().all()
                .log().body()
                .spec(Specs.response)
                .extract().as(WishListedListing.class);
        assertEquals("21375511", data.getListing().getWishListedO().getId());
    }

    @Test
    void deleteWishList() {

        given()
                .log().all()
                .spec(requestPost)
                .urlEncodingEnabled(false)
                .queryParam("key", key)
                .when()
                .delete("/api/v2/wishlisted_listings/1144175595/21375511")
                .then()
                .log().status()
                .log().body()
                .spec(Specs.response);
    }
}
