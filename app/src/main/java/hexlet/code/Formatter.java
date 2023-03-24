package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {

    public static String format(Map<String, Map<String, Object>> map, String format) {
        return switch (format) {
            case "stylish" -> Stylish.format(map);
            case "plain" -> Plain.format(map);
            default -> throw new RuntimeException("Unknown format: " + format);
        };
    }


}
