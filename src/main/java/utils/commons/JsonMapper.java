package utils.commons;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JsonMapper {
    private static PropertiesManager properties = PropertiesManager.getInstance();

    private JsonMapper() {
        throw new IllegalStateException("JsonMapper cannot be instantiated");
    }

    public static Iterator<String> getDataFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File(properties.getProperty("jsonPath"));
        List<String> data = null;
        try {
            data = objectMapper.readValue(file, List.class);
        } catch (IOException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Could not read JSON file");
        }
        return data.iterator();
    }

}
