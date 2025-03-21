import java.util.*;

class Students implements Comparable<Students> {
    int age;
    String name;

    Students(int a, String n) {
        this.age = a;
        this.name = n;
    }

    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

    public int compareTo(Students that) {
        if (this.age > that.age) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class sortingUsingComparable {
    public static void main(String[] args) {
        List<Students> al = new ArrayList<>();
        al.add(new Students(20, "Akash"));
        al.add(new Students(21, "Mani"));
        al.add(new Students(22, "Anand"));

        Collections.sort(al);
        for (Students s : al) {
            System.out.println(s);
        }
    }
}
