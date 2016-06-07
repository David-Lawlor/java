/*Sdev3
  PACKAGE_NAME
  Created by David
  13:46   29/10/2014
  Software Development 3
*/

import java.util.ArrayList;

public class Club {
    private ArrayList<Membership> members;

    public Club(){
        members = new ArrayList<Membership>();
    }

    public void join(Membership x){
        members.add(x);
    }

    public int getNumberOfMembers(){
        return members.size();
    }


}
