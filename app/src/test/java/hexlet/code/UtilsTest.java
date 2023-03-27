package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void testGetFileExtension() {
        String path1 = "./src/test/resources/file1.json";
        String path2 = "./src/test/resources/";
        assertThat(Utils.getSourceFormat(path1)).isEqualTo("json");
        assertThat(Utils.getSourceFormat(path2)).isEqualTo((""));
    }
}
