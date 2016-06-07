package Exercise3;/*Sdev3
  PACKAGE_NAME
  Created by David Lawlor
  14:04   28/10/2014
  Software Development 3
*/

public class University {
    private String uName;
    private Department[] dList;

    public University(String uName, String[] dNames, int[] dIds){
        this.uName = uName;
        dList = new Department[dNames.length];
        for (int i = 0; i < dNames.length; i++){
            dList[i] = new Department(dNames[i],dIds[i]);
        }
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void changeDepartmentName(String oldD, String newD){
        for (int i = 0; i < dList.length; i++ ){
            if (dList[i].getdName().equals(oldD))
                dList[i].setdName(newD);
        }
    }

    public void showList(){
        for (Department x: dList){
            System.out.println("Department ID: " + x.getdId() + " Department Name " + x.getdName());
        }
    }

    class Department{
        private String dName;
        private int dId;

        public Department(String dName, int dId){
            this.dName = dName;
            this.dId = dId;
        }

        public String getdName() {
            return dName;
        }

        public void setdName(String dName) {
            this.dName = dName;
        }

        public int getdId() {
            return dId;
        }

        public void setdId(int dId) {
            this.dId = dId;
        }
    }
}
