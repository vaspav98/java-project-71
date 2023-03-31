package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {

    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName).toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("result_json.json");
        resultPlain = readFixture("result_plain.txt");
        resultStylish = readFixture("result_stylish.txt");
    }

    @Test
    public void testGenerateFromJsonToStylish() throws Exception {
        String jsonFilePath1 = getFixturePath("file1.json").toString();
        String jsonFilePath2 = getFixturePath("file2.json").toString();
        String expected = resultStylish;

        assertThat(Differ.generate(jsonFilePath1, jsonFilePath2, "stylish")).isEqualTo(expected);
    }

    @Test
    public void testGenerateFromJsonToPlain() throws Exception {
        String jsonFilePath1 = getFixturePath("file1.json").toString();
        String jsonFilePath2 = getFixturePath("file2.json").toString();
        String expected = resultPlain;

        assertThat(Differ.generate(jsonFilePath1, jsonFilePath2, "plain")).isEqualTo(expected);
    }

    @Test
    public void testGenerateFromJsonToJson() throws Exception {
        String jsonFilePath1 = getFixturePath("file1.json").toString();
        String jsonFilePath2 = getFixturePath("file2.json").toString();
        String expected = resultJson;

        assertThat(Differ.generate(jsonFilePath1, jsonFilePath2, "json")).isEqualTo(expected);
    }

    @Test
    public void testGenerateFromJsonToDefault() throws Exception {
        String jsonFilePath1 = getFixturePath("file1.json").toString();
        String jsonFilePath2 = getFixturePath("file2.json").toString();
        String expected = resultStylish;

        assertThat(Differ.generate(jsonFilePath1, jsonFilePath2)).isEqualTo(expected);
    }

    @Test
    public void testGenerateFromYamlToStylish() throws Exception {
        String yamlFilePath1 = getFixturePath("file1.yml").toString();
        String yamlFilePath2 = getFixturePath("file2.yml").toString();
        String expected = resultStylish;

        assertThat(Differ.generate(yamlFilePath1, yamlFilePath2, "stylish")).isEqualTo(expected);
    }

    @Test
    public void testGenerateFromYamlToPlain() throws Exception {
        String yamlFilePath1 = getFixturePath("file1.yml").toString();
        String yamlFilePath2 = getFixturePath("file2.yml").toString();
        String expected = resultPlain;

        assertThat(Differ.generate(yamlFilePath1, yamlFilePath2, "plain")).isEqualTo(expected);
    }

    @Test
    public void testGenerateFromYamlToJson() throws Exception {
        String yamlFilePath1 = getFixturePath("file1.yml").toString();
        String yamlFilePath2 = getFixturePath("file2.yml").toString();
        String expected = resultJson;

        assertThat(Differ.generate(yamlFilePath1, yamlFilePath2, "json")).isEqualTo(expected);
    }

    @Test
    public void testGenerateFromYamlToDefault() throws Exception {
        String yamlFilePath1 = getFixturePath("file1.yml").toString();
        String yamlFilePath2 = getFixturePath("file2.yml").toString();
        String expected = resultStylish;

        assertThat(Differ.generate(yamlFilePath1, yamlFilePath2)).isEqualTo(expected);
    }
}
