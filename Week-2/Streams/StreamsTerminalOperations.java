import java.util.*;
import java.util.stream.Collectors;

public class StreamsTerminalOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);

        // 1. forEach() - Print all numbers
        System.out.println("Numbers in the list:");
        numbers.stream().forEach(System.out::println);
        // OR numbers.stream().forEach(n->System.out.println(n));

        // 2. count() - Count the numbers in the list
        long count = numbers.stream().count();
        System.out.println("\nTotal Count: " + count);

        // 3. collect() - Collect elements into a List
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("\nSquared Numbers: " + squaredNumbers);

        // 4. reduce() - Find the sum of all numbers
        int sum = numbers.stream().reduce(0, Integer::sum);
        // OR int sum = numbers.stream().reduce(0, (c, e) -> c + e);
        System.out.println("\nSum of Numbers: " + sum);

        // 5. findFirst() - Get the first element
        // findFirst() is a method of Optional interface
        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println("\nFirst Element: " + first.orElse(-1));

        // 6. findAny() - Get any random element (useful in parallel streams)
        Optional<Integer> any = numbers.parallelStream().findAny();
        System.out.println("\nAny Element: " + any.orElse(-1));

        // 7. anyMatch() - Check if any number is greater than 90
        boolean anyGreaterThan90 = numbers.stream().anyMatch(n -> n > 90);
        System.out.println("\nAny number greater than 90? " + anyGreaterThan90);

        // 8. allMatch() - Check if all numbers are greater than 5
        boolean allGreaterThan5 = numbers.stream().allMatch(n -> n > 5);
        System.out.println("\nAre all numbers greater than 5? " + allGreaterThan5);

        // 9. noneMatch() - Check if no number is negative
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("\nAre there no negative numbers? " + noneNegative);
    }
}
