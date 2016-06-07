/*IdeaProjects
  PACKAGE_NAME
  Created by David
  13:53   09/03/2015
  Software Development 3
*/

import java.io.Serializable;

public class Logon implements Serializable {
  private String userName;
  private transient String password;

  public Logon(String userName, String password){
    this.userName = userName;
    this.password = password;
  }

  public String toString(){
    if(password == null)
      password = "N/A";

    return "Username: " + userName + " Password: " + password;
  }



}
