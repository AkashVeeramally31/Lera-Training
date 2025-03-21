import java.util.*;
import java.util.stream.Collectors;

public class groupingEx {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie");

        Map<Character, List<String>> groupedByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println(groupedByFirstLetter);
        // Output: {A=[Alice, Anna], B=[Bob], C=[Charlie]}
    }
}
