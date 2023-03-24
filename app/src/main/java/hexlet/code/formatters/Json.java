package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class Json {

    public static String format(Map<String, Map<String, Object>> map) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(map);
        return json;
    }
}
