package ui.utility;

import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
@UtilityClass
public class TestDataReader {
    private Properties getTestDataFile()  {
        FileReader reader;
        try {
            reader = new FileReader("src/test/resources/data.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties props = new Properties();
        try {
            props.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }

    public String getTestData(String key) {
        return getTestDataFile().getProperty(key);
    }
}
