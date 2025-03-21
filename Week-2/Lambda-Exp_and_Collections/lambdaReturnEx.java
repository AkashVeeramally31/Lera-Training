
// if we have a functional interface 
//   interface A{
//    int add(int i, int j);
//   }
// in this case, we return int type from add method, for that we can write a lambda expression 
// in different ways.
// -- if we have a single statement you do not need of curly braces
// A obj1 =(i,j)- return i+j;

// -- if we want to return something in a single statement, no need to mention the return keyword
// A obj2 =(i,j)-i+j;

//Using Anonymous inner class.
// interface A {
//     public int add(int a, int b);
// }

// public class lambdaReturnEx {
//     public static void main(String[] args) {
//         A obj = new A() {
//             public int add(int a, int b) {
//                 return a + b;
//             }
//         };
//         int res = obj.add(4, 5);
//         System.out.println(res);
//     }
// }

//Using Lambda Expressions:
// interface A {
//     public int add(int a, int b);
// }

// public class lambdaReturnEx {
//     public static void main(String[] args) {
//         A obj = (int a, int b) -> {     
//             return a + b;
//         };
//         int res = obj.add(4, 5);
//         System.out.println(res);
//     }
// }

//Also written as:
interface A {
    public int add(int a, int b);
}

public class lambdaReturnEx {
    public static void main(String[] args) {
        A obj = (a, b) -> a + b;
        int res = obj.add(4, 5);
        System.out.println(res);
    }
}