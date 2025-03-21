// #1
// Stream is an interface, it contains a stream() method.
// Stream method return an object of type stream.
// Any operation can be performed inside the stream method.
// Any changes done inside the stream can be reflected on the actual list.
// Once we work with a stream, we can't reuse it. We can work with a stream only once.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class streamsEx {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        Stream<Integer> s1 = nums.stream();

        // If we directly print the stream, it doesn't give values but it gives the
        // output as 'java.util.stream.ReferencePipeline$Head@3f99bd52'. So we use
        // forEach() method to print the values.
        // System.out.println(s1);

        s1.forEach(n -> System.out.println(n));
        s1.forEach(n -> System.out.println(n));// Gives Runtime error beacause: only once we can work with a stream, we
                                               // can't reuse it.

    }
}