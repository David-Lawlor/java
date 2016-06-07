package example3;

public class Test {
    private static int i;
    private int j;

    public Test(){
        System.out.println("Constructor called");
    }
    static {
        i = 10;
        System.out.println("Static block called "+i);
    }

}

