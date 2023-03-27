package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String source, String inputFormat) throws Exception {
        ObjectMapper mapper;
        switch (inputFormat) {
            case "json":
                mapper = new ObjectMapper();
                break;
            case "yml":
            case "yaml":
                mapper = new YAMLMapper();
                break;
            default:
                throw new Exception("Unknown format: " + inputFormat);
        }

        String contentOfFile = Files.readString(Paths.get(source));

        Map<String, Object> map = mapper.readValue(contentOfFile,
                new TypeReference<Map<String, Object>>() { });
        return map;
    }
}
