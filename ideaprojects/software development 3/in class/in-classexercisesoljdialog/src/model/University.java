package model;

import java.util.ArrayList;

public class University {
	private String uName;
	private String president;
	private String location;
	private ArrayList<Department> deptlist = new ArrayList<Department>();

	public University(String name, String p, String l, int deptId[],
			String deptName[]) {
		uName = name;
		president = p;
		location = l;

		for (int i = 0; i < deptId.length; i++) {
			deptlist.add((new Department(deptId[i], deptName[i])));
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

	public void addDep(Department d) {
		deptlist.add(d);
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
		System.out.println("Inside removeDep method"+name);
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
