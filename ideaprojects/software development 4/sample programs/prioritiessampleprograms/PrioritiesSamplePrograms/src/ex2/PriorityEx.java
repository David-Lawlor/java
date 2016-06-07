package ex2;

public class PriorityEx implements Runnable {

    @Override
    public void run() {
            for (int x = 1; x <= 3; x++)
                    System.out.println(x + " This is thread "
                                    + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
            Thread t1 = new Thread(new PriorityEx(), "Thread  A");
            Thread t2 = new Thread(new PriorityEx(), "Thread  B");
            Thread t3 = new Thread(new PriorityEx(), "Thread  C");
            t1.setPriority(10);
           
            t2.start();
            t3.start();
            t1.start();
    }
}