package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {

    @Test
    public void testGenerateJsonStylish() throws Exception {
        String jsonFilePath1 = "./src/test/resources/file1.json";
        String jsonFilePath2 = "./src/test/resources/file2.json";
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";

        assertThat(Differ.generate(jsonFilePath1, jsonFilePath2, "stylish")).isEqualTo(expected);
    }

    @Test
    public void testGenerateYamlStylish() throws Exception {
        String yamlFilePath1 = "./src/test/resources/file1.yml";
        String yamlFilePath2 = "./src/test/resources/file2.yml";
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";

        assertThat(Differ.generate(yamlFilePath1, yamlFilePath2, "stylish")).isEqualTo(expected);
    }

    @Test
    public void testGeneratePlain() throws Exception {
        String filePath1 = "./src/test/resources/file1.json";
        String filePath2 = "./src/test/resources/file2.json";
        String expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";

        assertThat(Differ.generate(filePath1, filePath2, "plain")).isEqualTo(expected);
    }

    @Test
    public void testGenerateJson() throws Exception {
        String filePath1 = "./src/test/resources/file1.json";
        String filePath2 = "./src/test/resources/file2.json";
        String expected = "{\"chars1\":{\"value\":[\"a\",\"b\",\"c\"],\"status\":\"unchanged\"},\"chars2\":"
                + "{\"value2\":false,\"value1\":[\"d\",\"e\",\"f\"],\"status\":\"changed\"},\"checked\":{\"value2\""
                + ":true,\"value1\":false,\"status\":\"changed\"},\"default\":{\"value2\":[\"value1\",\"value2\"],\""
                + "value1\":null,\"status\":\"changed\"},\"id\":{\"value2\":null,\"value1\":45,\"status\":\"changed\"},"
                + "\"key1\":{\"value\":\"value1\",\"status\":\"deleted\"},\"key2\":{\"value\":\"value2\",\"status\":\""
                + "added\"},\"numbers1\":{\"value\":[1,2,3,4],\"status\":\"unchanged\"},\"numbers2\":{\"value2\":"
                + "[22,33,44,55],\"value1\":[2,3,4,5],\"status\":\"changed\"},\"numbers3\":{\"value\":[3,4,5],"
                + "\"status\":\"deleted\"},\"numbers4\":{\"value\":[4,5,6],\"status\":\"added\"},\"obj1\":{\"value\":"
                + "{\"nestedKey\":\"value\",\"isNested\":true},\"status\":\"added\"},\"setting1\":{\"value2\":"
                + "\"Another value\",\"value1\":\"Some value\",\"status\":\"changed\"},\"setting2\":{\"value2\":"
                + "300,\"value1\":200,\"status\":\"changed\"},\"setting3\":{\"value2\":\"none\",\"value1\":true,"
                + "\"status\":\"changed\"}}";
        assertThat(Differ.generate(filePath1, filePath2, "json")).isEqualTo(expected);
    }
}
