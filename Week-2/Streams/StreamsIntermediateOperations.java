import java.util.*;
import java.util.stream.*;

public class StreamsIntermediateOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 10, 20, 60, 70, 80, 90, 100);

        // Applying all intermediate operations
        List<Integer> result = numbers.stream()
                .distinct() // Removes duplicates
                .filter(n -> n % 20 == 0) // Keeps numbers divisible by 20
                .map(n -> n / 10) // Divides each number by 10
                .sorted(Comparator.reverseOrder()) // Sorts in descending order
                .skip(1) // Skips the first element
                .limit(3) // Limits to the first 4 elements
                .collect(Collectors.toList()); // Collects into a list

        // Printing the result
        System.out.println("Processed List: " + result);
    }
}

// This output results from:

// Filtering numbers divisible by 20 → [20, 40, 60, 80, 100]
// Removing duplicates → [20, 40, 60, 80, 100]
// Mapping (divide by 10) → [2, 4, 6, 8, 10]
// Sorting in descending order → [10, 8, 6, 4, 2]
// Skipping the first element → [8, 6, 4, 2]
// Limiting to 3 elements → [8, 6, 4]