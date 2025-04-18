import java.util.Vector;

public class vector {
    public static void main(String[] args) {

        // Create a new vector
        Vector<Integer> v = new Vector<>(3, 2);

        // Add elements to the vector
        v.addElement(1);
        v.addElement(2);
        v.addElement(3);

        // Insert an element at index 1
        v.insertElementAt(0, 1);

        // Remove the element at index 2
        v.removeElementAt(2);

        // Print the elements of the vector
        for (int i : v) {
            System.out.println(i);
        }

        // Total capacity=initialCapacity + capacityIncrement
        System.out.println(v.capacity());

        // Prints the first element
        System.out.println(v.firstElement());

        // Adding more elements
        v.add(4);
        v.add(7);
        v.add(10);
        System.out.println(v);
        System.out.println(v.size());
    }
}
