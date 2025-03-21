import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

public class listToMap {
    public static void main(String[] args) {
        List<String> li = Arrays.asList("Akash", "Anand", "Mani");

        Map<String, Integer> m = li.stream().collect(Collectors.toMap(name -> name, String::length));
        System.out.println(m);
    }
}
