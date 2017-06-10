import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleStreamJava {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path readmeFile = Paths.get(SimpleStreamJava.class.getResource("README.md").toURI());

        long numberOfAs = countOfCharInFile(readmeFile, "a");
        long numberOfBs = countOfCharInFile(readmeFile, "b");

        System.out.println(String.format("Lines with a:%d | Lines with b:%d", numberOfAs, numberOfBs));
    }

    private static long countOfCharInFile(Path readmeFilePath, String characterToSerach) throws IOException {
        return Files.lines(readmeFilePath).parallel().filter(line->line.contains(characterToSerach)).count();
    }
}
