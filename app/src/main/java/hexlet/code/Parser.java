package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String inputFormat) throws Exception {
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


        Map<String, Object> map = mapper.readValue(content,
                new TypeReference<Map<String, Object>>() { });
        return map;
    }
}
