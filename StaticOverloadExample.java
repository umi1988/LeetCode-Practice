package org.example.learn;

public class StaticOverloadExample {

    // 1. Static method with two integer parameters
    public static int multiply(int a, int b) {
        return a * b;
    }

    // 2. Overloaded static method with three integer parameters
    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // 3. Overloaded static method with two double parameters
    public static double multiply(double a, double b) {
        return a * b;
    }

    // 4. Overloaded main method
    public static void main(String arg1) {
        System.out.println("Overloaded main method called with: " + arg1);
    }

    // Standard JVM entry point main method
    public static void main(String[] args) {
        // Calling overloaded multiply methods
        System.out.println("Result 1 (two ints): " + multiply(5, 4));
        System.out.println("Result 2 (three ints): " + multiply(5, 4, 2));
        System.out.println("Result 3 (two doubles): " + multiply(5.5, 2.0));

        // Calling the overloaded main method explicitly
        main("Hello Java!");
    }
}

