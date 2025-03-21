import java.util.*;

public class arrayList {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        System.out.println(al.size()); // Gives the size of Arraylist
        System.out.println(al);
        System.out.println(al.indexOf(3)); // Gives the index of element present in ArrayList
        System.out.println(al.remove(2));// Removes the element from ArrayList.
        System.out.println(al);
        al.clear(); // Makes ArrayList empty.
        System.out.println(al);

        // Again adding elements
        al.add(1);
        al.add(2);
        al.set(1, 5); // Updation.
        System.out.println(al);

        // We can also add elements into list by:-
        List<Integer> nums = Arrays.asList(4, 5, 6, 7, 8);
        System.out.println(nums);
    }
}

// The only difference between ArrayList and Vector is that, vector is
// synchronized where as ArrayList is non synchronized.