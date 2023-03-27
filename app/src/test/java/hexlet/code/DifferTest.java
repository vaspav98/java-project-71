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
    public void testGenerateStylish() throws Exception {
        String jsonFilePath1 = "./src/test/resources/file1.json";
        String ymlFilePath2 = "./src/test/resources/file2.yml";
        String expected = resultStylish;

        assertThat(Differ.generate(jsonFilePath1, ymlFilePath2, "stylish")).isEqualTo(expected);
    }

    @Test
    public void testGeneratePlain() throws Exception {
        String ymlFilePath1 = "./src/test/resources/file1.yml";
        String jsonFilePath2 = "./src/test/resources/file2.json";
        String expected = resultPlain;

        assertThat(Differ.generate(ymlFilePath1, jsonFilePath2, "plain")).isEqualTo(expected);
    }

    @Test
    public void testGenerateJson() throws Exception {
        String jsonFilePath1 = "./src/test/resources/file1.json";
        String jsonFilePath2 = "./src/test/resources/file2.json";
        String expected = resultJson;

        assertThat(Differ.generate(jsonFilePath1, jsonFilePath2, "json")).isEqualTo(expected);
    }

    @Test
    public void testGenerateDefault() throws Exception {
        String ymlFilePath1 = "./src/test/resources/file1.yml";
        String ymlFilePath2 = "./src/test/resources/file2.yml";
        String expected = resultStylish;

        assertThat(Differ.generate(ymlFilePath1, ymlFilePath2)).isEqualTo(expected);
    }
}
