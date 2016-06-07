/*IdeaProjects
  PACKAGE_NAME
  Created by David
  12:05   22/04/2015
  Software Development 3
*/

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Exercise1Hashset {
  public static void main(String[] args) {

    Set<String> invites = new HashSet<>();

    try(Scanner read = new Scanner(new FileInputStream("Software Development 4/Labs/Lab13 Collections 2/src/names.txt"))){
      while (read.hasNext()){
        invites.add(read.nextLine());
      }
    } catch (FileNotFoundException e) {
      e.getMessage();
    }

    Iterator iter = invites.iterator();
    while(iter.hasNext()){
      System.out.println(iter.next());
    }
  }

}
