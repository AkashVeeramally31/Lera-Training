import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomSortExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Charlie", "Bob", "Alice", "David");

        List<String> sortedNames = names.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());

        System.out.println(sortedNames);
        // Output: [Bob, Alice, David, Charlie]
    }
}
