package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import db.UniOperations;

public class University {
    private int id;
	private String uName;
	private String president;
	private String location;
	private ArrayList<Department> deptlist = new ArrayList<Department>();
    private ResultSet rset;
    private UniOperations uo;

	public University(UniOperations uo, int id, String n, String l, String p) {
		this.uo = uo;
        this.id=id;
        uName = n;
        location=l;
        president=p;

        deptlist = new ArrayList<Department>();
        refreshList(id);
	}

    public void refreshList(int id) {
        System.out.println("ID is:"+id);
        rset = uo.getDepts(id);

        if (deptlist.size() > 0) {

            for (int i = deptlist.size()-1; i >=0; i--) {
                deptlist.remove(i);
            }
        }
        try {
            while (rset.next()) {
                System.out.println("In here");
                Department d = new Department(rset.getInt(1), rset.getString(2));
                deptlist.add(d);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

	public String getuName() {
		return uName;
	}

	public String getPresident() {
		return president;
	}

	public String getLocation() {
		return location;
	}

	public Department getDept(int i) {
		return deptlist.get(i);
	}

	public int getNumDept() {
		return deptlist.size();
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

//	public void addDep(Department d) {
//		deptlist.add(d);
//	}

    public void addDep()
    {
        System.out.println("Inside addDep");
        rset = uo.getLastRow();
        try {
            {
                Department d = new Department(rset.getInt(1),rset.getString(2));
                deptlist.add(d);
                System.out.println(rset.getInt(1)+ rset.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
	public void changedeptname(String old, String newname) {
		for (int i = 0; i < deptlist.size(); i++) {
			if (deptlist.get(i).getDeptName().equals(old))
				deptlist.get(i).setDeptName(newname);
		}
	}
	public int findDep(String n) {
		int returnValue = -1; // -1 if there is no match
		for (int i = 0; i < deptlist.size(); i++) {
			if (n.equals(deptlist.get(i).getDeptName()))
				returnValue = i;
		}
		return returnValue;
	}
	public int removeDep(String name)
	{
		int num = 0;
		for (int i=0;i<deptlist.size();i++)
		{
			if((name.equals(deptlist.get(i).getDeptName())))
			{
				deptlist.remove(i);
				num++;
			}
		}
		return num;
	}
}
