package org.example.learn;

class ABC{
    public void m1(){
        System.out.println("m1 in ABC");
    }

    static public void m2(){
        System.out.println("static m2 in ABC");
    }
}

class XYZ extends ABC{
    @Override
    public void m1(){
        System.out.println("m1 in XYZ");
    }
    //No, you cannot override static methods in Java.

    // While you can define a static method in a subclass with the same name and signature as one in the superclass,
    // this is known as method hiding, not overriding.
    //
    //Why Static Methods Cannot Be Overridden
    // Method overriding is a key feature of runtime polymorphism (dynamic binding).
    // It allows the Java Virtual Machine (JVM) to decide which method to call at runtime based on the actual type of the object.
    //
    // In contrast, static methods are:
    // Bound at Compile-Time: They use static binding. The compiler decides which method to call based on the reference type, not the actual object.
    // Class-Level Members: They belong to the class itself rather than any specific instance of that class

    // Because of these reasons, static methods cannot be overridden in the traditional sense.
    // Instead, if you define a static method with the same signature in a subclass, it hides the superclass's static method rather than overriding it.

    // This is not an override, it's a new static method in XYZ
    static public void m2(){
        System.out.println("static m2 in XYZ");
    }
}

public class OverRidingDemo2 {
    public static void main(String[] args) {
        ABC obj1 = new ABC();
        XYZ obj2 = new XYZ();

        obj1.m1(); // Calls m1 in ABC
        obj2.m1(); // Calls m1 in XYZ

        System.out.println("===============================");

        ABC ref1 = new XYZ();
        ref1.m1(); // Calls m1 in XYZ (runtime polymorphism)

        System.out.println("===============================");

        ABC.m2(); // Calls static m2 in ABC
        XYZ.m2(); // Calls static m2 in XYZ

        System.out.println("===============================");

        ref1.m2(); // Calls static m2 in ABC (static methods are called based on reference type)
    }
}
