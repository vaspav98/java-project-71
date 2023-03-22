package hexlet.code;

import java.io.File;
import java.nio.file.Path;

public class Utils {

    public static String getFileExtension(Path filepath) {
        File file = new File(filepath.toString());
        if (file.isFile()) {
            String[] arr = file.getName().split("\\.");
            return arr[arr.length - 1];
        }
        return "";
    }
}
