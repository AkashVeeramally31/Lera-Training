import java.util.Random;
import java.util.stream.Stream;

public class infiniteStream {
    public static void main(String[] args) {
        Stream.generate(() -> new Random().nextInt(100)) // Generate random numbers
                .forEach(System.out::println);
    }
}
