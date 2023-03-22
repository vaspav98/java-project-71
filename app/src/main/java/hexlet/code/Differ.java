package hexlet.code;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(Path filepath1, Path filepath2, String format) throws Exception {
        String inputFile1Format = Utils.getFileExtension(filepath1);
        Map<String, Object> map1 = Parser.parse(filepath1, inputFile1Format);
        String inputFile2Format = Utils.getFileExtension(filepath2);
        Map<String, Object> map2 = Parser.parse(filepath2, inputFile2Format);


        Map<String, Map<String, Object>> resultMap = new LinkedHashMap<>();
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            Map<String, Object> description = new HashMap<>();

            if (!map1.containsKey(key)) {
                description.put("status", "added");
                description.put("value", map2.get(key));
                resultMap.put(key, description);
            } else if (!map2.containsKey(key)) {
                description.put("status", "deleted");
                description.put("value", map1.get(key));
                resultMap.put(key, description);
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                description.put("status", "unchanged");
                description.put("value", map1.get(key));
                resultMap.put(key, description);
            } else {
                description.put("status", "changed");
                description.put("value1", map1.get(key));
                description.put("value2", map2.get(key));
                resultMap.put(key, description);
            }
        }
        if (format.equals("stylish")) {
            return Formatter.stylish(resultMap);
        }
        throw new RuntimeException("Unknown format: " + format);
    }
}
