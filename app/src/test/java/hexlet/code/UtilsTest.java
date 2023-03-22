package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UtilsTest {

    @Test
    public void testGetFileExtension() {
        Path path1 = Paths.get("./src/test/resources/file1.json");
        Path path2 = Paths.get("./src/test/resources/");
        assertThat(Utils.getFileExtension(path1)).isEqualTo("json");
        assertThat(Utils.getFileExtension(path2)).isEqualTo((""));
    }
}
