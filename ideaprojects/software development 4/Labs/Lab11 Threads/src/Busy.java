/**
 * Created by DL on 15/04/2015.
 */
public class Busy implements Runnable {
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
        Thread t1 = new Thread(new Busy(), "ThreadA");


        t1.start();
        System.out.println(Thread.currentThread() + "end");
    }
}
