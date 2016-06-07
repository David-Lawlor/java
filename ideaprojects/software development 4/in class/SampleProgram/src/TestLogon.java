/*IdeaProjects
  PACKAGE_NAME
  Created by David
  14:00   09/03/2015
  Software Development 3
*/

import java.io.*;

public class TestLogon {
    private final String FILENAME = "Software Development 4/In class/SampleProgram/files/Logon.dat";// write a car

  private void write() {
    Logon u1 = new  Logon("User1", "Pass1");
    Logon u2 = new  Logon("User2", "Pass2");
    try (FileOutputStream fo = new FileOutputStream(FILENAME);
         ObjectOutputStream oo = new ObjectOutputStream(
                 new BufferedOutputStream(fo))) {
      oo.writeObject(u1);
      System.out.println("User written:\t" + u1);
      oo.writeObject(u2);
      System.out.println("User written:\t" + u2);
    } catch (NotSerializableException e) // doesn't implement serializable
    {
      System.out.println(e);
    } catch (IOException e) // file output error
    {
      System.out.println(e);
    }
  }


  private void read() {
    Logon lo;
    try (ObjectInputStream oi = new ObjectInputStream(
            new BufferedInputStream(new FileInputStream(FILENAME)))) {
      do {
        try {
          lo = (Logon) oi.readObject();
          System.out.println("User read:\t" + lo);
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

  public static void main(String[] args) {
    TestLogon tl = new TestLogon();
    tl.write();
    tl.read();
  }

  }

