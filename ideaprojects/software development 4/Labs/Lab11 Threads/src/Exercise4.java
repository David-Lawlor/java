/**
 * Created by DL on 15/04/2015.
 */
public class Exercise4 implements Runnable {

    private String name;

    public Exercise4(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "start");
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " is busy....");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(Thread.currentThread() + "end");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + "start");
        Thread t1 = new Thread(new Exercise4("Harry"), "HThread");
        Thread t2 = new Thread(new Exercise4("Sally"), "SThread");

//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "end");
    }
}