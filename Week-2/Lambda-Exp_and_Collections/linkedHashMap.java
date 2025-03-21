
// Iterating over LinkedHashMap
import java.util.*;

public class linkedHashMap {

    public static void main(String args[]) {

        // Initialization of a LinkedHashMap
        // using Generics
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();

        // Inserting elements into Map
        // using put() method
        lhm.put(3, "Geeks");
        lhm.put(2, "For");
        lhm.put(1, "Geeks");

        // For-each loop for traversal over Map
        for (Map.Entry<Integer, String> mapElement : lhm.entrySet()) {

            Integer k = mapElement.getKey();

            // Finding the value
            // using getValue() method
            String v = mapElement.getValue();

            // Printing the key-value pairs
            System.out.println(k + " : " + v);
        }
    }
}
