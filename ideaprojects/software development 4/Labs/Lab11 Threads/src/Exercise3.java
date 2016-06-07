/**
 * Created by DL on 15/04/2015.
 */
public class Exercise3 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "start");
        for (int i = 0; i < 10; i++) {
            System.out.println("Busy....");
        }
        System.out.println(Thread.currentThread() + "end");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + "start");
        Thread t1 = new Thread(new Exercise3(), "ThreadA");

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "end");
    }
}