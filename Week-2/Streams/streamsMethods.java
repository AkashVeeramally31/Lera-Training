// #1
// Stream provides a lot of methods to work upon.
// filter() method returns a new Stream that contains the value which satisfies the given condition. The filter method is used to select elements as per the Predicate passed as an argument.
// map() takes each value and performs operations on it. It returns a stream consisting of the results of applying the given function to the elements of this stream.
// reduce() method does not return the stream but it gives the value of a type that you defined in the stream. It is used to reduce the elements of a stream to a single value.
// The reduce method takes a BinaryOperator as a parameter.

// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Stream;

// public class streamsMethods {
//     public static void main(String[] args) {
//         List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
//         Stream<Integer> s1 = nums.stream();
//         Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
//         // s2.forEach(n -> System.out.println(n)); // Prints the even numbers only. Also
//         // we cant reuse s2.

//         Stream<Integer> s3 = s2.map(n -> n * 2); // Gives error because we are using s2 second time. To print s3,
//                                                  // comment down the s2.
//         // s3.forEach(n -> System.out.println(n)); //Comment s3 because we are using for
//         // 'res' otherwise don't initialize 'res'.

//         // Doing addition for all elements present in s3.
//         int res = s3.reduce(0, (c, e) -> c + e);
//         System.out.println(res);
//     }
// }

//The above code can also be written as:-
import java.util.Arrays;
import java.util.List;
//import java.util.stream.Stream;

public class streamsMethods {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        int res = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, (c, e) -> c + e);
        System.out.println(res);

        // We can also print directly.
        // System.out.println(nums.stream()
        // .filter(n -> n % 2 == 0)
        // .map(n -> n * 2)
        // .reduce(0, (c, e) -> c + e));
    }
}

// If you want to use Big Data, then first you have to apply a filter on it to
// separate useful data.
// After applying a filter, you need to transform it into the required data with
// the help of a map.
// And the graph of it, can be made with the help of the reduce method.
// We can reduce the code by applying methods one after the other.