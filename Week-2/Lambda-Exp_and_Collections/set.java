// import java.util.*;

// public class set {
//     public static void main(String[] args) {
//         Set<Integer> hs = new HashSet<>();
//         hs.add(3);
//         hs.add(8);
//         hs.add(1);
//         hs.add(4);
//         System.out.println(hs);// Prints in random order.
//         System.out.println(hs.size()); // Prints the size.

//         System.out.println("Prints in the order that are present in the set");
//         Iterator<Integer> i = hs.iterator();
//         while (i.hasNext()) {
//             System.out.println(i.next());
//         }
//     }
// }

//Treeset:-
import java.util.*;

public class set {
    public static void main(String[] args) {
        Set<Integer> hs = new TreeSet<>();
        hs.add(3);
        hs.add(8);
        hs.add(1);
        hs.add(4);
        System.out.println(hs);// Prints in Sorted order.
        System.out.println(hs.size()); // Prints the size.
    }
}
