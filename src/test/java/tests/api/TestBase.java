package tests.api;

import helpers.CustomApiListener;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    public String wishlistId;
    public DeleteWishList deleteWishList = new DeleteWishList();

    @BeforeAll
    static void setup() {
        RestAssured.filters(CustomApiListener.withCustomTemplates());
    }
}



