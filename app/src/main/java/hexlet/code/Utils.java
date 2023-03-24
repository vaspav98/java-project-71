package hexlet.code;

import java.io.File;

public class Utils {

    public static String getFileExtension(String filepath) {
        File file = new File(filepath);
        if (file.isFile()) {
            String[] arr = file.getName().split("\\.");
            return arr[arr.length - 1];
        }
        return "";
    }
}
