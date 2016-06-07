package example1;

public class EmpRow {

    int Id;
    String EmpLastName;
    String EmpFirstName;

    final static int INSERTED = -1;

    public EmpRow() {
        this.Id = INSERTED;
        this.EmpLastName = new String();
        this.EmpFirstName = new String();
    }

    public EmpRow(int Id, String EmpLastName, String EmpFirstName) {
        this.Id = Id;
        this.EmpLastName = EmpLastName;
        this.EmpFirstName = EmpFirstName;
    }
}
