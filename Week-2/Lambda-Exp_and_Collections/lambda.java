// @FunctionalInterface
// interface A {
//     void show();
// }

// public class lambda {
//     public static void main(String[] args) {
//         A obj = new A() {
//             public void show() {
//                 System.out.println("in A show");
//             }
//         };
//         obj.show();
//     }
// }

// In Java, a lambda expression is a concise way to implement a functional interface. 
//    A functional interface is an interface that has only one abstract method, and it can be implemented using a lambda expression.
// -- In the previous lecture we see that we are making a class or inner class to implement the functional interface 
//    but using lambda expression we do not need of new class and inner class to implement.

// @FunctionalInterface
// interface A {
//     void show();
// }

// public class lambda {
//     public static void main(String[] args) {
//         A obj = () -> { // Using Lambda expression.
//             System.out.println("in A show"); // Also written as: A obj=()->System.out.println("in A show");
//         };
//         obj.show();
//     }
// }

//Using example with passing parameters:
@FunctionalInterface
interface A {
    void show(int a);
}

public class lambda {
    public static void main(String[] args) {
        A obj = (int a) -> { // Also written as A obj= a -> System.out.println("in A show"+a);
                             // OR A obj= (a) -> System.out.println("in A show"+a); //Type is alo not needed.
            System.out.println("in A show:" + a);
        };
        obj.show(5);
    }
}