package Exercise3;/*Sdev3
  PACKAGE_NAME
  Created by David
  12:31   31/10/2014
  Software Development 3
*/

import java.util.ArrayList;

public class TestUniversity {
    public static void main(String[] args) {

        int [] dIds = {1,2,3,4};
        String [] dNames = {"Computing", "Business", "Languages", "Engineering"};

        University u = new University("IT Tallaght", dNames, dIds);

        u.showList();
        u.changeDepartmentName("Business", "Business & Marketing");
        u.showList();


    }
}
