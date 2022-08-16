package tests.api.specs;

import config.api.ApiConfig;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class Specs {
    public static ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

    public static RequestSpecification requestGet = with()
            .log().body()
//            .baseUri("https://www.airbnb.ru/")
            .contentType(JSON)
            .header("x-airbnb-api-key", config.apiKey());
//                .cookie("_aat", .config.aat()) /вроде не надо, но не помню почему/


    public static RequestSpecification requestPost = with()
            .baseUri("https://www.airbnb.ru/")
            .contentType(JSON)
            .header("x-csrf-token", config.xCsrfToken())
            .cookie("_csrf_token", config.csrfToken())
            .cookie("_aat", config.aat())
            .cookie("_airbed_session_id", config.airbedSessionId());


    public static ResponseSpecification response = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}

