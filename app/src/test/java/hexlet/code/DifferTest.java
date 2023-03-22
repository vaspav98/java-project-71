package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    @Test
    public void testGenerateJson() throws Exception {
        Path jsonFile1 = Paths.get("./src/test/resources/file1.json");
        Path jsonFile2 = Paths.get("./src/test/resources/file2.json");

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        assertThat(Differ.generate(jsonFile1, jsonFile2)).isEqualTo(expected);
    }

    @Test
    public void testGenerateYaml() throws Exception {
        Path yamlFile1 = Paths.get("./src/test/resources/file1.yml");
        Path yamlFile2 = Paths.get("./src/test/resources/file2.yml");

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        assertThat(Differ.generate(yamlFile1, yamlFile2)).isEqualTo(expected);
    }

}
