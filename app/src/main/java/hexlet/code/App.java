package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {

    @Parameters(paramLabel = "filepath1 ", description = "path to first file")
    String filepath1;

    @Parameters(paramLabel = "filepath2 ", description = "path to second file")
    String filepath2;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: stylish]")
    String format;


    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2, format));
        return Differ.generate(filepath1, filepath2, format);
    }
}
