package Exercise2;

/**
 * Created by David on 14/10/2014.
 */
public class Staff {
    StaffMember[] staff;

    public Staff() {
        staff = new StaffMember[]{
                new Executive("John", "1 This St", "0874323476", "R6574635", 2423.07),
                new Employee("Paul", "2 That St", "0854345222", "P8884635", 1246.15),
                new Employee("Dave", "3 Other St", "0864343566", "S9876635", 1169.23),
                new Hourly("Joanne", "4 Long Ave", "0836789676", "T0987635", 10.55),
                new Volunteer("Norma", "5 Short Ave", "0864323456"),
                new Volunteer("Kate", "6 Pecks Lane", "08546767676"),
                new Commission("Molly", "7 Nowhere Rd", "0864326789", "L6599635", 6.25, .2),
                new Commission("Joe", "8 My Place", "0864344545", "G8888635", 9.75, .15)
        };
    }

    public void processStaff() {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i] instanceof Executive && staff[i].getName().equals("John")) {
                Executive e = (Executive) staff[i];
                e.awardBonus(500);
            }
            if (staff[i] instanceof Hourly && staff[i].getName().equals("Joanne")) {
                Hourly h = (Hourly) staff[i];
                h.addHours(40);
            }
            if (staff[i] instanceof Commission && staff[i].getName().equals("Molly")) {
                Commission c = (Commission) staff[i];
                c.addHours(35);
                c.addSales(400);
            }
            if (staff[i] instanceof Commission && staff[i].getName().equals("Joe")) {
                Commission c = (Commission) staff[i];
                c.addHours(40);
                c.addSales(950);
            }
        }
    }

    public void payday() {

        for (int i = 0; i < staff.length; i++){

            System.out.println(staff[i]);
            staff[i].pay();
            if (staff[i] instanceof Volunteer)
                System.out.println("Thanks!\n------------------------------");
            else
                System.out.println("Paid " + staff[i].pay() + "\n------------------------------");
        }
    }
}
