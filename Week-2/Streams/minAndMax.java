import java.util.*;

public class minAndMax {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(54, 88, 11, 44, 94, 21, 34, 19, 8, 22);

        Optional<Integer> min = nums.stream().min(Integer::compareTo);
        Optional<Integer> max = nums.stream().max(Integer::compareTo);

        System.out.println("Minimum: " + min.orElse(-1));
        System.out.println("Maximum: " + max.orElse(-1));

        // If we mention only min,it will give output as 'Optional followed by value
        // i.e.., Optinal[8]'. If we mention
        // .orElse(-1) it will the only value.
    }
}