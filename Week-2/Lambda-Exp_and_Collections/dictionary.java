//Difference between Dictionary and HashMap:-
//Dictionary in Java:-
// Dictionary<K, V> is an abstract class in Java.
// It is the older way of storing key-value pairs (before Java 2).
// It has been replaced by Map interface (which includes HashMap, TreeMap, etc.).
// Hashtable is a concrete subclass of Dictionary.

//HashMap:-
//HashMap<K, V> is a modern implementation of key-value storage.
// It is part of the Java Collections Framework (Map interface).
// It is not synchronized (not thread-safe).
// Allows one null key and multiple null values.

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class dictionary {
    public static void main(String[] args) {

        // create a Dictionary instance
        // using Hashtable
        Dictionary<String, Integer> d = new Hashtable<>();

        // Adding key-value pairs
        d.put("A", 25);
        d.put("B", 30);
        d.put("C", 35);

        // Retrieving a value using a key
        System.out.println("Value of B: " + d.get("B"));

        // Replacing an existing value
        int oldValue = d.put("C", 40);
        System.out.println("Old Value of C: " + oldValue);

        // Removing a key-value pair
        d.remove("A");

        // Displaying remaining key-value pairs
        Enumeration<String> k = d.keys();
        while (k.hasMoreElements()) {
            String key = k.nextElement();
            System.out.println("Key: " + key + ", Value: " + d.get(key));
        }
    }
}

// In Java, Enumeration is an interface (java.util.Enumeration) used to iterate
// over legacy collections such as Vector and Hashtable. It is considered an
// older approach and has been largely replaced by Iterator.