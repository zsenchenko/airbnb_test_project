package tests.api;

import org.junit.jupiter.api.DisplayName;
import tests.api.specs.Specs;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Specs.requestPost;

public class DeleteWishList extends TestBase {

    @DisplayName("Delete the wishlist")
    void deleteWishList() {
        given()
                .spec(requestPost)
                .when()
                .delete("/api/v2/wishlists/" + wishlistId)
                .then()
                .log().status()
                .spec(Specs.response);
    }
}
