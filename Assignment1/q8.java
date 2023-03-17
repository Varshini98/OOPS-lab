import java.util.Scanner;

class account
{


	String accname;
	double Balance;

	void credit(double p)
	{
	Balance=Balance+p;
	}

	void debit(double q)
	{
	Balance=Balance-q;
	}

}

class SBI extends account
{
Scanner input=new Scanner(System.in);
double interest;

	void input()
       {

		System.out.println("Enter sbi customer details ");
		accname=input.nextLine();
		Balance=input.nextDouble();
		double credit_amt=input.nextDouble();
		credit(credit_amt);
		double debit_amt=input.nextDouble();
		debit(debit_amt);

		calculate_interest(Balance);

	}


	void calculate_interest(double bal)
	{

		double r= 8;
		interest=(bal*r)/100;

	}

	void output()
	{
	System.out.println(accname+" "+Balance+" "+interest);
	}

}

class HDFC extends account
{

Scanner input=new Scanner(System.in);
double interest;

	void input()
       {

		System.out.println("Enter hdfc customer details");
		accname=input.next();
		Balance=input.nextDouble();
		double credit_amt=input.nextDouble();
		credit(credit_amt);
		double debit_amt=input.nextDouble();
		debit(debit_amt);

		calculate_interest(Balance);

	}

	void calculate_interest(double bal)
	{

		double r=7;
		interest=(bal*r)/100;


	}

	void output()
	{
	System.out.println(accname+" "+Balance+" "+ interest);
	}

}

public class q8
 {

	public static void main(String args[])
	{

		Scanner input=new Scanner(System.in);
		HDFC hc=new HDFC();
		SBI sb=new SBI();
		
		sb.input();
		hc.input();
		
		sb.output();
		hc.output();


	}
}

