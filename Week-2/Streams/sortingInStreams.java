//sorted() and parallelStream() method:-
// By using the sorted() method with a stream, it will return a sorted stream.
// There is a method called parallelStream() used with the filter that creates multiple threads to work faster.
// parallelStream should not be used with a sorted() method as sorting requires all the elements together, so there multiple threads will create an ambiguity.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class sortingInStreams {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 6, 1, 4, 9, 8, 7, 2);
        // Printing even values in sorted order
        Stream<Integer> s = nums.stream()
                .filter(n -> n % 2 == 0)
                .sorted();
        s.forEach(n -> System.out.println(n));

        System.out.println();

        // Printing odd values
        // With a parallel stream (parallelStream()), elements may be printed in a
        // random order.
        Stream<Integer> s2 = nums.parallelStream().filter(n -> n % 2 != 0);
        s2.forEach(n -> System.out.println(n));

        // If you want to maintain order while using parallel streams, use
        // forEachOrdered():
        // s2.forEachOrdered(n -> System.out.println(n));
    }
}