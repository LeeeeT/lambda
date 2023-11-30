import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String programText = new String(Files.readAllBytes(Paths.get(args[0])));
        lambda.Term programLambda = converter.TextToLambda.convert(programText);
        runner.Iterable runner = new runner.Iterable(programLambda);

        System.out.println(runner.term);
        for (lambda.Term term : runner) {
            System.out.println(term);
        }
    }
}