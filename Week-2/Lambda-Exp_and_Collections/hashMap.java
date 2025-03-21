import java.util.*;

public class hashMap {
    public static void main(String[] args) {
        Map<Integer, String> hm = new HashMap<>();
        // Map<Key,Value>
        hm.put(1, "Akash");
        hm.put(2, "Mani");
        hm.put(3, "Anand");
        System.out.println(hm);

        System.out.println(hm.keySet());// Prints only keys
        for (int key : hm.keySet()) {
            System.out.println(key + ":" + hm.get(key));
        }
        hm.remove(3);
        System.out.println(hm);

        System.out.println(hm.values());// Prints only values.

        System.out.println(hm.containsKey(1));
        System.out.println(hm.containsValue("Anand"));
    }
}

// The only difference between Hashmap and Hashtable is that, Hashtable is
// synchronized where as Hashmap is non synchronized.
