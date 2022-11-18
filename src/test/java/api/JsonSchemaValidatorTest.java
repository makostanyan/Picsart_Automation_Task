package api;

import org.testng.annotations.Test;

public class JsonSchemaValidatorTest {
    private final String URL = "https://api.picsart.com/localizations/en/messages?project=reusable_components,photo_editor";

    @Test
    public void schemaValidator() {
        RequestUtilities.get(URL);
        ResponseUtilities.validateResponseWithJsonSchema("schema.json");
    }
}
