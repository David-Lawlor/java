package exercise;

import java.io.*;

class TestLogin {

    private final String FILENAME = "files/login.dat";// write a login

    private void write() {
        Login c1 = new Login("user1","pass1");
        Login c2 = new Login("user2","pass2");
        try (FileOutputStream fo = new FileOutputStream(FILENAME);
             ObjectOutputStream oo = new ObjectOutputStream(
                     new BufferedOutputStream(fo))) {
            oo.writeObject(c1);
            System.out.println("Login written:\t" + c1);
            oo.writeObject(c2);
            System.out.println("Login written:\t" + c2);
        } catch (NotSerializableException e) // doesn't implement serializable
        {
            System.out.println(e);
        } catch (IOException e) // file output error
        {
            System.out.println(e);
        }
    }

    private void read() {
        Login l;
        try (ObjectInputStream oi = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(FILENAME)))) {
            do {
                try {
                    l = (Login) oi.readObject();
                    System.out.println("Login read:\t" + l);
                } catch (EOFException e) {
                    System.out.println("EOF reached");
                    break;
                }
            } while (true);
        } catch (IOException e) // file input error
        {
            System.out.println(e);
        } catch (ClassNotFoundException e) // class not found in this
        // application
        {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        TestLogin t = new TestLogin();
        t.write();
        t.read();
    }
}
