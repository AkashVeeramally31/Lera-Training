
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class forEach {
    public static void main(String[] args) {
        // List<Integer> al=new ArrayList<>();
        List<Integer> al = Arrays.asList(2, 3, 4, 5, 6);

        // Normal for loop
        System.out.println("Printing using Normal for loop:-");
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }

        // Enhanced for loop
        System.out.println("Printing using Enhanced for loop:-");
        for (int n : al) {
            System.out.println(n);
        }

        // forEach() method:-
        System.out.println("Printing using forEach() method:-");
        al.forEach(n -> System.out.println(n));
        // al.forEach(System.out::println);

        // forEach(System.out::println) – Iterates over each element in the Stream and
        // prints it.
    }
}
