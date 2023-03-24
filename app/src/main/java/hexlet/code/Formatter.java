package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.Map;

public class Formatter {

    public static String format(Map<String, Map<String, Object>> map, String format) throws IOException {
        return switch (format) {
            case "stylish" -> Stylish.format(map);
            case "plain" -> Plain.format(map);
            case "json" -> Json.format(map);
            default -> throw new RuntimeException("Unknown format: " + format);
        };
    }


}
