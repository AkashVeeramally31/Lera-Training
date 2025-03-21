import java.util.stream.Stream;

public class IterateExample {
    public static void main(String[] args) {
        Stream.iterate(1, n -> n + 2) // Start from 1, increment by 2
                .limit(5)
                .forEach(System.out::println);
        // Output: 1, 3, 5, 7, 9
    }
}
