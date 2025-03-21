// import java.util.ArrayList;
// import java.util.*;
// import java.util.List;

// public class sortingUsingComparator {
//     public static void main(String[] args) {
//         Comparator<Integer> com = new Comparator<Integer>() {
//             public int compare(Integer i, Integer j) {
//                 if (i > j) {
//                     return 1;
//                 } else {
//                     return -1;
//                 }
//             }
//         };

//         List<Integer> al = new ArrayList<>();
//         al.add(29);
//         al.add(31);
//         al.add(13);
//         al.add(45);
//         al.add(78);
//         Collections.sort(al, com);
//         // Collections.sort(al);
//         System.out.println(al);
//     }
// }

// import java.util.ArrayList;
// import java.util.*;
// import java.util.List;

// public class sortingUsingComparator {
//     public static void main(String[] args) {
//         Comparator<Integer> com = new Comparator<Integer>() {
//             public int compare(Integer i, Integer j) {
//                 if (i % 10 > j % 10) {
//                     return 1;
//                 } else {
//                     return -1;
//                 }
//             }
//         };

//         // Sort based on unit's digit og a number, i.e.., based on below input the
//         // output should be [31,13,45,78,29].
//         List<Integer> al = new ArrayList<>();
//         al.add(29);
//         al.add(31);
//         al.add(13);
//         al.add(45);
//         al.add(78);
//         Collections.sort(al, com);
//         System.out.println(al);
//     }
// }

//As Comparator is a functional interface we can also use Lambda expression to implement it.
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class sortingUsingComparator {
    public static void main(String[] args) {
        Comparator<Integer> com = (i, j) -> i % 10 > j % 10 ? 1 : -1;

        // Sort based on unit's digit og a number, i.e.., based on below input the
        // output should be [31,13,45,78,29].
        List<Integer> al = new ArrayList<>();
        al.add(29);
        al.add(31);
        al.add(13);
        al.add(45);
        al.add(78);
        Collections.sort(al, com);
        System.out.println(al);
    }
}
