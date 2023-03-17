package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(Path filepath1, Path filepath2) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map1 = mapper.readValue(new File(filepath1.toString()),
                new TypeReference<Map<String, Object>>() { });
        Map<String, Object> map2 = mapper.readValue(new File(filepath2.toString()),
                new TypeReference<Map<String, Object>>() { });

        var result = new StringBuilder("{\n");

        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            if (!map1.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            } else if (!map2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else if (map1.get(key).equals(map2.get(key))) {
                result.append("    ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else {
                result.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
                result.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }
}
