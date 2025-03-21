import java.util.*;

public class stack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(21);
        st.push(19);
        st.push(48);
        st.push(11);

        // st.pop(); // Removes first element i.e.., 7.
        // System.out.println(st);

        System.out.println("Peek:" + st.peek());
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }

    }
}
