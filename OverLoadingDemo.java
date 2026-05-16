package org.example.learn;

/**
 * Method overloading is a feature in Java that allows a class
 * to have more than one method with the same name,
 * as long as their parameter lists are different.
 *
 * This is also known as compile-time polymorphism or static polymorphism.
 * The compiler determines which method to call based on the number and type of arguments passed to the method.
 *
 * In the example below, we have a class A with three overloaded methods named m1.
 * Each method has a different parameter list:
 *
 * - m1(int a): Takes an integer parameter.
 * - m1(String s): Takes a string parameter.
 * - m1(int a, String s): Takes both an integer and a string parameter.
 *
 * In the main method, we create an instance of class A and
 * call each of the overloaded methods with different arguments.
 * The appropriate method is called based on the argument types and count.
 *
 */
class A{
    public void m1(int a){
        System.out.println("m1 with int: " + a);
    }

    public void m1(String s){
        System.out.println("m1 with String: " + s);
    }

    public void m1(int a, String s){
        System.out.println("m1 with int and String: " + a + ", " + s);
    }
}

public class OverLoadingDemo {
    public static void main(String[] args) {
        A obj = new A();
        obj.m1(10); // Calls m1(int a)
        obj.m1("Hello"); // Calls m1(String s)
        obj.m1(20, "World"); // Calls m1(int a, String s)
    }
}
