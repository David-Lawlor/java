package exercise;

public class TestProgram {
	public static void main(String[] args)
	    {
	       DataSet bankData = new DataSet();
	 
	       bankData.add(new CurrentAccount(1000));
	       bankData.add(new SavingsAccount(5.5,10000));
	       bankData.add(new CurrentAccount(2000));
	 
	       System.out.printf("Average bank balance = €%,.2f%n",bankData.getAverage());
	       Measurable max = bankData.getMaximum();
	       System.out.printf("Highest bank balance = €%,.2f%n",max.getMeasure());
	       
	       DataSet empData = new DataSet();
	 
	       empData.add(new FullTime("John", 50000));
	       empData.add(new PartTime("Paddy",30.0,40.0));
	       empData.add(new FullTime("Nick", 90000));
	 
	       System.out.printf("Average pay = €%,.2f%n",empData.getAverage());
	       max = empData.getMaximum();
	       System.out.printf("Highest pay value = €%,.2f",max.getMeasure());
	    }
}
