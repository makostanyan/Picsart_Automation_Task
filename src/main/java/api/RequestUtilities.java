package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
public class RequestUtilities {
    private static ValidatableResponse response;
    public static ValidatableResponse getResponse() {
        return response;
    }
    public static void get(String endpoint) {
        response = RestAssured.given()
                .spec(requestSpecification())
                .when()
                .get(endpoint)
                .then()
                .log()
                .ifError();
    }
    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
}
