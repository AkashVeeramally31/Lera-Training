import java.util.*;

public class iteratorInterface {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(4);
        al.add(9);
        al.add(2);
        al.add(5);
        al.add(3);
        Iterator<Integer> vals = al.iterator();
        while (vals.hasNext()) {
            System.out.println(vals.next());
        }
    }
}
