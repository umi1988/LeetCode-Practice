package org.example.learn;

/**
 * Method overriding is a feature in Java that allows a subclass to provide a specific implementation of a method that is already defined in its superclass.
 * The method in the subclass must have the same name, return type, and parameter list as the method in the superclass.
 *
 * This is also known as runtime polymorphism or dynamic polymorphism.
 * The decision of which method to call is made at runtime based on the actual object type, not the reference type.
 *
 * In the example below, we have three classes: AA, B, and C.
 * Class B extends AA and overrides the m1 method, while class C extends B and also overrides the m1 method.
 *
 * In the main method, we create instances of each class and call their m1 methods to demonstrate method overriding.
 * We also show how upcasting and downcasting work with overridden methods.
 *
 **/

class AA{
    public void m1(){
        System.out.println("m1 in class AA");
    }
}

class B extends AA{
    @Override
    public void m1(){
        System.out.println("m1 in class B");
    }
}

class C extends B{
    @Override
    public void m1(){
        System.out.println("m1 in class C");
    }
}

public class OverRidingDemo {
    public static void main(String[] args) {
        AA objA = new AA();
        B objB = new B();
        C objC = new C();

        objA.m1(); // Calls m1 in class A
        objB.m1(); // Calls m1 in class B
        objC.m1(); // Calls m1 in class C

        System.out.println("===============================");

        AA ref1 = new B();
        AA ref2 = new C();

        ref1.m1(); // Calls m1 in class B (runtime polymorphism)
        ref2.m1(); // Calls m1 in class C (runtime polymorphism)

        System.out.println("===============================");

        B ref3 = new C();
        ref3.m1(); // Calls m1 in class C (runtime polymorphism)

        System.out.println("===========Upcasting ====================");
        //upcasting is a process of converting a subclass reference to a superclass reference.
        // It is done implicitly by the Java compiler and does not require an explicit cast.

        AA ref4 = new C(); // Upcasting
        ref4.m1(); // Calls m1 in class C (runtime polymorphism)

        System.out.println("===========Downcasting ====================");
        //downcasting is the process of converting a superclass reference back to a subclass reference.
        // It requires an explicit cast and can throw a ClassCastException if the object being cast

        if (ref4 instanceof C) {
            C ref5 = (C) ref4; // Downcasting
            ref5.m1(); // Calls m1 in class C
        }
    }
}
