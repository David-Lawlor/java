public class TestClass {
    public static void main(String [] args){
        IPayable [] emps = {new Invoice("Printer", "01234", 375, 2 ),
                            new Invoice("Ink Cartridges", "56789", 79.95,4),
                            new HourlyEmployee("John", "Smith", "6578431N", 60, 30),
                            new HourlyEmployee("Lisa", "Kelly", "9865431M", 20, 12),
                            new HourlyEmployee("Mary", "Reilly", "9875431M", 20, 8)
                           };

        for (int i = 0; i < emps.length; i++){
            System.out.println(emps[i].toString());
        }

        System.out.println("The total number of employees processed is: " + Employee.getEmps());
        System.out.println("The total number of invoices processed is: " + Invoice.getInvoices());
        System.out.println("The total amount of VAT paid is: €" + Invoice.getTotalVAT());
        System.out.println("The total amount of tax paid is: " + Employee.getTotalTax());
    }
}
