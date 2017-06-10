import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleStreamJava {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path readmeFile = Paths.get(SimpleStreamJava.class.getResource("README.md").toURI());
        List<String> lines = Files.lines(readmeFile).collect(Collectors.toList());

        long numberOfAs = lines.parallelStream().filter(line->line.contains("a")).count();
        long numberOfBs = lines.parallelStream().filter(line->line.contains("b")).count();

        System.out.println(String.format("Lines with a:%d | Lines with b:%d", numberOfAs, numberOfBs));
    }
}
