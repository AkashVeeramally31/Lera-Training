//FlatMap converts a list of lists into a single list.

import java.util.*;
import java.util.stream.Collectors;

public class flatMap {
    public static void main(String[] args) {
        List<List<String>> names = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D"),
                Arrays.asList("F", "G"));
        List<String> flatList = names.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flatList);
    }
}
