package example4;

public class StaticBlockExample {
    static {
        System.out.println("Static block 1");
    }

    public StaticBlockExample(){
        System.out.println("This is constructor");
    }

    private static String staticString = "This is a static string";

    static {
        System.out.println("Static block 2 "
                + staticString);
    }

    static {
        staticMethod();
        System.out.println("Static block 3");
    }

    public static void staticMethod() {
        System.out.println("Static method 1");
    }

    public static void staticMethod2() {
        System.out.println("Static method 2");
    }
}


