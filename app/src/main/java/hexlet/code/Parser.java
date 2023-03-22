package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.nio.file.Path;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(Path filepath, String inputFileFormat) throws Exception {
        ObjectMapper mapper;
        switch (inputFileFormat) {
            case "json":
                mapper = new ObjectMapper();
                break;
            case "yml":
                mapper = new YAMLMapper();
                break;
            default:
                throw new Exception("Unknown format: " + inputFileFormat);
        }

        Map<String, Object> map = mapper.readValue(new File(filepath.toString()),
                new TypeReference<Map<String, Object>>() { });
        return map;
    }
}
