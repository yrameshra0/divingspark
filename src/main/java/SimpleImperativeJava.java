import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SimpleImperativeJava {
    public static void main(String[] args) throws IOException {
        InputStream readmeStream = SimpleImperativeJava.class.getResourceAsStream("README.md");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(readmeStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int result=bufferedInputStream.read();
        while (result!= -1){
            outputStream.write((byte)result);
            result = bufferedInputStream.read();
        }

        String readmeString = outputStream.toString();

        String[] lines = readmeString.split("\n");

        long numberOfAs = 0L;
        long numberOfBs = 0L;

        for(String line:lines){
            if(line.contains("a"))
                numberOfAs+=1;
            if(line.contains("b"))
                numberOfBs+=1;
        }

        System.out.println(String.format("Lines with a:%d | Lines with b:%d", numberOfAs, numberOfBs));
    }
}
