package hexlet.code.formatters;

import java.util.Map;

public class Plain {

    public static String format(Map<String, Map<String, Object>> map) {
        var result = new StringBuilder();

        for (Map.Entry<String, Map<String, Object>> pair : map.entrySet()) {
            String status = (String) pair.getValue().get("status");
            String key = pair.getKey();
            Object value = normalize(pair.getValue().get("value"));
            Object value1 = normalize(pair.getValue().get("value1"));
            Object value2 = normalize(pair.getValue().get("value2"));

            switch (status) {
                case "added":
                    result.append("Property '").append(key)
                            .append("' was added with value: ").append(value).append("\n");
                    break;
                case "deleted":
                    result.append("Property '").append(key)
                            .append("' was removed\n");
                    break;
                case "unchanged":
                    break;
                case "changed":
                    result.append("Property '").append(key)
                            .append("' was updated. From ").append(value1).append(" to ").append(value2).append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown status: " + status);
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private static Object normalize(Object arg) {
        if (arg instanceof String) {
            return "'" + arg + "'";
        }
        if (arg instanceof Integer || arg instanceof Character || arg instanceof Boolean || arg == null) {
            return arg;
        }
        return "[complex value]";
    }
}
