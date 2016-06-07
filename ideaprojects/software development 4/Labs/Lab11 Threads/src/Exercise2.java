/**
 * Created by DL on 15/04/2015.
 */
public class Exercise2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "start");


            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Busy....");
                    Thread.currentThread();
                    Thread.sleep(10);
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        System.out.println(Thread.currentThread() + "end");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + "start");
        Thread t1 = new Thread(new Exercise2(), "BusyThread");
        t1.start();
        try {
            Thread.currentThread();
            Thread.sleep(70);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println(Thread.currentThread() + "end");
    }
}

