package hexlet.code;

import java.util.Map;

public class Differ {

    public static String generate(String path1, String path2, String format) throws Exception {
        String inputSource1Format = Utils.getSourceFormat(path1);
        Map<String, Object> map1 = Parser.parse(path1, inputSource1Format);
        String inputSource2Format = Utils.getSourceFormat(path2);
        Map<String, Object> map2 = Parser.parse(path2, inputSource2Format);

        Map<String, Map<String, Object>> resultMap = DiffMaker.genDiff(map1, map2);
        return Formatter.format(resultMap, format);
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }
}
