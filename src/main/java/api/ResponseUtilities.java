package api;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;

public class ResponseUtilities {
    private static ValidatableResponse getResponse() {
        return RequestUtilities.getResponse();
    }
    public static void validateResponseWithJsonSchema(String schemaPath) {
        getResponse()
                .assertThat()
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath(schemaPath));
    }
}