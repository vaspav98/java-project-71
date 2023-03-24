package hexlet.code.formatters;

import java.util.Map;

public class Stylish {

    public static String format(Map<String, Map<String, Object>> map) {
        var result = new StringBuilder("{\n");

        for (Map.Entry<String, Map<String, Object>> pair : map.entrySet()) {
            String status = (String) pair.getValue().get("status");
            String key = pair.getKey();
            Object value = pair.getValue().get("value");
            Object value1 = pair.getValue().get("value1");
            Object value2 = pair.getValue().get("value2");

            switch (status) {
                case "added":
                    result.append("  + ").append(key).append(": ").append(value).append("\n");
                    break;
                case "deleted":
                    result.append("  - ").append(key).append(": ").append(value).append("\n");
                    break;
                case "unchanged":
                    result.append("    ").append(key).append(": ").append(value).append("\n");
                    break;
                case "changed":
                    result.append("  - ").append(key).append(": ").append(value1).append("\n");
                    result.append("  + ").append(key).append(": ").append(value2).append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown status: " + status);
            }
        }
        result.append("}");
        return result.toString();
    }
}
