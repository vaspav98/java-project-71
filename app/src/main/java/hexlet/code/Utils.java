package hexlet.code;

import java.io.File;

public class Utils {

    public static String getSourceFormat(String path) {
        File file = new File(path);
        if (file.isFile()) {
            String[] arr = file.getName().split("\\.");
            return arr[arr.length - 1];
        }
        return "";
    }
}
