import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        String result = words.stream()
                .collect(Collectors.joining(" "));

        System.out.println(result); // Output: Java Streams are powerful
    }
}
