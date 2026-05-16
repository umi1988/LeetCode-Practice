package org.example.learn;


class Test11{
    public void m11(int a){
        System.out.println("m1 with int: " + a);
    }

    public void m11(String s){
        System.out.println("static m1 with String: " + s);
    }

    /**
     Yes, you can overload static methods in Java.

     In Java, method overloading allows you to have multiple methods with the same name
     but different parameter lists within the same class. This applies to both instance methods and static methods.

     When you overload a static method, you can define multiple static methods with the same name
     but different parameters. The compiler will determine which method to call based on the arguments
     passed when the method is invoked.
     */
    public static void m11(int a, String s){
        System.out.println("m1 with int and String: " + a + ", " + s);
    }
}

public class OverLoadingDemo2 {
    public static void main(String[] args) {
        Test11 obj = new Test11();
        obj.m11(10); // Calls m11(int a)
        obj.m11("Hello"); // Calls m11(String s)
        Test11.m11(20, "World"); // Calls static m11(int a, String s)
    }
}
